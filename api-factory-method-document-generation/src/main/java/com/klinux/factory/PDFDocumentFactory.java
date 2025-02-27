package com.klinux.factory;

import com.klinux.document.Document;
import com.klinux.document.PDFDocument;

public class PDFDocumentFactory extends DocumentFactory {
	 
	@Override
	    public Document createDocument() {
	        return new PDFDocument();
	    }

	    @Override
	    public String generateDocument(String content) throws Exception {
	        PDFDocument document = (PDFDocument) createDocument();
	        document.generate(content);  // This creates the file
	        return "document.pdf";  // Return the file name (or full path if needed)
	    }
}
