package com.klinux.document;

public class ExcelDocument implements Document {
	 @Override
	    public String generate(String content) throws Exception {
	        // File name for Excel
	        String fileName = "document.xlsx";
	        
	        // Logic for generating the Excel file...

	        return fileName;
	    }
}
