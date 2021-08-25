package com.sunlife.filesplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunlife.filesplit.service.SplitCouplePDFService;
import com.sunlife.filesplit.service.SplitPDFService;

@SpringBootApplication
public class FilesplitApplication implements CommandLineRunner{

	@Autowired
	SplitPDFService splitPDFService;
	
	@Autowired
	SplitCouplePDFService splitCouplePDFService;
	
	public static void main(String[] args) {
		SpringApplication.run(FilesplitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		splitPDFService.SplitFile();
		splitCouplePDFService.SplitFile();
	}

	
}
