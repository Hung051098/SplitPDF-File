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
public class SplitOddPDFService {

	public void SplitFile(String input, String ouput) throws IOException {
		// Loading an existing PDF document
		File file = new File(input);
		PDDocument doc = PDDocument.load(file);

		// Instantiating Splitter class
		Splitter splitter = new Splitter();

		// splitting the pages of a PDF document
		List<PDDocument> Pages = splitter.split(doc);

		Iterator<PDDocument> iterator = Pages.listIterator();
		int i = 1;
		while (iterator.hasNext()) {
			PDDocument pd = iterator.next();
			if (i % 2 == 1) {
				pd.save(ouput+"/out_" + i + ".pdf");
			}
			i++;
		}
		System.out.println("Odd Page PDF splitted");
	}


}
