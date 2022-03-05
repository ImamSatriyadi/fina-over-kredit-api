package com.fina.fina.controller;

import java.util.List;

import com.fina.fina.DTO.response.PerhitunganDTO;
import com.fina.fina.model.CSF;
import com.fina.fina.service.CSFService;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/fina_overkredit/api/csf")
// @SecurityScheme(name = "auth", type = SecuritySchemeType.HTTP, scheme =
// "bearer")
public class CSFController {
    @Autowired
    CSFService csfService;

    @GetMapping("/data")
    public ResponseEntity<List<CSF>> getData(@RequestParam String email) {
        return ResponseEntity.ok(csfService.getAll(email));
    }

    @GetMapping("/perhitungan")
    public ResponseEntity<PerhitunganDTO> getPerhitungan(@RequestParam String no_kontrak) {
        return ResponseEntity.ok(csfService.getperhitungan(no_kontrak));
    }
}
