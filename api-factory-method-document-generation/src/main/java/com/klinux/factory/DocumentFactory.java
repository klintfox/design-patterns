package com.klinux.factory;

import com.klinux.document.Document;

public abstract class DocumentFactory {
	 public abstract Document createDocument();

	    // Modify this method to return the file name of the generated document
	    public String generateDocument(String content) throws Exception {
	        Document document = createDocument();
	        String fileName = document.generate(content);
	        return fileName;
	    }
}