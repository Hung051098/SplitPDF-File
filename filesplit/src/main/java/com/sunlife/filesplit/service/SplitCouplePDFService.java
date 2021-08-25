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
public class SplitCouplePDFService {

	public void SplitFile() throws IOException {
		System.out.println("hùng");
		// Loading an existing PDF document
		File file = new File("D:/Sunlife/AssetPDF/in/filedemo.pdf");
		PDDocument doc = PDDocument.load(file);

		// Instantiating Splitter class
		Splitter splitter = new Splitter();
		
		// Cắt file thành 2 thành 1 file
		splitter.setSplitAtPage(2);
		
		// splitting the pages of a PDF document
		List<PDDocument> Pages = splitter.split(doc);
		couplePage(Pages);
	}

	public void couplePage(List<PDDocument> Pages) throws IOException {
		Iterator<PDDocument> iterator = Pages.listIterator();
		int i = 1;
		while (iterator.hasNext()) {
			PDDocument pd = iterator.next();
			pd.save("D:/Sunlife/AssetPDF/out/couplepage/filedemo_" + i + ".pdf");
			i++;
		}
		System.out.println("Couple Page PDF splitted");
	}
}
