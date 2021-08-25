package com.sunlife.filesplit.service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.stereotype.Service;

@Service
public class SplitPDFService {

	public void SplitFile() throws IOException {
		System.out.println("hùng");
		// Loading an existing PDF document
		File file = new File("D:/Sunlife/AssetPDF/in/filedemo.pdf");
		PDDocument doc = PDDocument.load(file);

		// Instantiating Splitter class
		Splitter splitter = new Splitter();

		// splitting the pages of a PDF document
		List<PDDocument> Pages = splitter.split(doc);

		oddPage(Pages);
		onePage(Pages);
	}

	public void onePage(List<PDDocument> Pages) throws IOException {
		Iterator<PDDocument> iterator = Pages.listIterator();
		int i = 1;
		while(iterator.hasNext()){ 
	        PDDocument pd = iterator.next(); 
			pd.save("D:/Sunlife/AssetPDF/out/onepage/filedemo_" + i++ + ".pdf");           
	     } 
		System.out.println("One Page PDF splitted");
	}

	public void oddPage(List<PDDocument> Pages) throws IOException {
		Iterator<PDDocument> iterator = Pages.listIterator();
		int i = 1;
		while (iterator.hasNext()) {
			PDDocument pd = iterator.next();
			if (i % 2 == 1) {
				pd.save("D:/Sunlife/AssetPDF/out/oddpage/filedemo_" + i + ".pdf");
			}
			i++;
		}
		System.out.println("Odd Page PDF splitted");
	}

}
