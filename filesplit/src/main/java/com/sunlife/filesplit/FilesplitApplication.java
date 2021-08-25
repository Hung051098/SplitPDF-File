package com.sunlife.filesplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunlife.filesplit.service.SplitCouplePDFService;
import com.sunlife.filesplit.service.SplitOddPDFService;
import com.sunlife.filesplit.service.SplitOnePDFService;

@SpringBootApplication
public class FilesplitApplication implements CommandLineRunner{

	@Value("${file.split.input.forder}")
	String input;
	@Value("${file.split.onepage.forder}")
	String onepage;
	@Value("${file.split.oddpage.forder}")
	String oddpage;
	@Value("${file.split.couplepage.forder}")
	String couplepage;
	
	@Autowired
	SplitOnePDFService splitOnePDFService;
	
	@Autowired
	SplitOddPDFService splitOddPDFService;
	
	@Autowired
	SplitCouplePDFService splitCouplePDFService;
	
	public static void main(String[] args) {
		SpringApplication.run(FilesplitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		splitOnePDFService.SplitFile(input, onepage);
		splitOddPDFService.SplitFile(input, oddpage);
		splitCouplePDFService.SplitFile(input, couplepage);
	}

	
}
