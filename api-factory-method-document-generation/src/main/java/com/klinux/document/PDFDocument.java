package com.klinux.document;

import java.io.FileOutputStream;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PDFDocument implements com.klinux.document.Document {

	@Override
    public String generate(String content) throws Exception {
        // Specify the file name
        String fileName = "document.pdf";
        
        // Initialize PdfWriter
        PdfWriter writer = new PdfWriter(new FileOutputStream(fileName));
        
        // Initialize PdfDocument with PdfWriter
        PdfDocument pdfDoc = new PdfDocument(writer);
        
        // Initialize the layout document (which handles content layout)
        Document document = new Document(pdfDoc);
        
        // Add content as a paragraph
        document.add(new Paragraph(content));
        
        // Close the document
        document.close();

        // Return the file name
        return fileName;
    }
	
	
}