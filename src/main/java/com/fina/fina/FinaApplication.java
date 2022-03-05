package com.fina.fina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.Resource;

import com.fina.fina.service.FileStorageService;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class FinaApplication implements CommandLineRunner {
	@Resource
	FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(FinaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		storageService.deleteAll();
		storageService.init();

	}

}
