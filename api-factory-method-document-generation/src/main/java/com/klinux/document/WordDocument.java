package com.klinux.document;

public class WordDocument implements Document {
	@Override
    public String generate(String content) throws Exception {
        // File name for Word
        String fileName = "document.docx";
        
        // Logic for generating the Word document...

        return fileName;
    }
}