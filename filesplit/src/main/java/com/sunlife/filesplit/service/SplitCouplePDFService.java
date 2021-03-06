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

	public void SplitFile(String input, String output) throws IOException {
		// Loading an existing PDF document
		File file = new File(input);
		PDDocument doc = PDDocument.load(file);

		// Instantiating Splitter class
		Splitter splitter = new Splitter();
		
		// Cắt file thành 2 page thành 1 file
		splitter.setSplitAtPage(2);
		
		// splitting the pages of a PDF document
		List<PDDocument> Pages = splitter.split(doc);
		Iterator<PDDocument> iterator = Pages.listIterator();
		int i = 1;
		while (iterator.hasNext()) {
			PDDocument pd = iterator.next();
			pd.save(output+"/out_" + i + ".pdf");
			i++;
		}
		System.out.println("Couple Page PDF splitted");
	}

}
