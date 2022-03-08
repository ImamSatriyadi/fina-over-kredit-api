package com.fina.fina.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fina.fina.DTO.request.NewCustomerDTO;
import com.fina.fina.DTO.response.ResponseMessage;
import com.fina.fina.model.FileInfo;
import com.fina.fina.model.TempDocumentNewCustomer;
import com.fina.fina.model.TempNewCustomer;
import com.fina.fina.service.CSFService;
import com.fina.fina.service.DocumentNewCustomerService;
import com.fina.fina.service.FileStorageService;
import com.fina.fina.service.NewCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/fina_overkredit/api/newcustomer")
// @SecurityScheme(name = "auth", type = SecuritySchemeType.HTTP, scheme =
// "bearer")
public class NewCustomerController {
    @Autowired
    NewCustomerService newCustomerService;

    @Autowired
    CSFService csfService;

    @Autowired
    FileStorageService storageService;

    @Autowired
    DocumentNewCustomerService documentNewCustomerService;

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody NewCustomerDTO newCustomerDto) {
        return ResponseEntity.ok(newCustomerService.saveCustomer(newCustomerDto));
    }

    @GetMapping("/rollBack")
    public void rollBack() {
        newCustomerService.rollBack();
    }

    @GetMapping("/showData")
    public ResponseEntity<?> showData() {
        return ResponseEntity.ok(newCustomerService.showData());
    }

    @GetMapping("/showDataById")
    public ResponseEntity<?> showDataById(@RequestParam int id_new_customer) {
        return ResponseEntity.ok(newCustomerService.showById(id_new_customer));
    }

    @GetMapping("/showIdNewCustomer")
    public ResponseEntity<?> showIdNewCustomer(@RequestParam String no_kontrak) {
        return ResponseEntity.ok(newCustomerService.findIdNoKontrak(no_kontrak));
    }

    @GetMapping("/showDataDocument")
    public ResponseEntity<?> showDataDocument(@RequestParam int id_new_customer) {
        return ResponseEntity.ok(documentNewCustomerService.getDataById(id_new_customer));
    }

    @GetMapping("/getNoKontrak")
    public ResponseEntity<?> showNoKontrak(@RequestParam int id_new_customer) {
        return ResponseEntity.ok(newCustomerService.findNoKontrak(id_new_customer));
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile[] file, @RequestParam String nameDoc,
            @RequestParam String no_kontrak) {
        String message = "";

        Optional<TempNewCustomer> tempNewCustomer = newCustomerService.findByNoKontrak(no_kontrak);
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.asList(file).stream().forEach(files -> {
                storageService.save(files);
                fileNames.add(files.getOriginalFilename());
                TempDocumentNewCustomer tempDocumentNewCustomer = new TempDocumentNewCustomer(
                        nameDoc,
                        "https://fina-overkredit-api.herokuapp.com/fina_overkredit/api/newcustomer/files/"
                                + files.getOriginalFilename(),
                        tempNewCustomer.get().getId());

                documentNewCustomerService.saveDocument(tempDocumentNewCustomer);
                newCustomerService.commit(no_kontrak);
                csfService.updateStatusPengajuan("DALAM PROSES PENGAJUAN", no_kontrak);
            });
            // storageService.save(file);
            // message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body("Uploaded the file successfully");
        } catch (Exception e) {
            message = "Could not upload the file: ";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(NewCustomerController.class, "getFile", path.getFileName().toString()).build()
                    .toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

}
