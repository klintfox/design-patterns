package com.klinux.service;

import com.klinux.factory.DocumentFactory;
import com.klinux.factory.ExcelDocumentFactory;
import com.klinux.factory.PDFDocumentFactory;
import com.klinux.factory.WordDocumentFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DocumentGenerationService {

    // Method to generate a document based on type and content
    public String generateDocument(String type, String content) throws Exception {
        DocumentFactory factory = getDocumentFactory(type);
        String fileName = factory.generateDocument(content); // Generate the document and get the file name

        // Optionally, handle additional steps like logging or file tracking here

        return fileName;  // Return the generated file name (could be used for further operations)
    }

    // Method to return the appropriate document factory based on the type
    private DocumentFactory getDocumentFactory(String type) {
        switch (type.toLowerCase()) {
            case "pdf":
                return new PDFDocumentFactory();
            case "excel":
                return new ExcelDocumentFactory();
            case "word":
                return new WordDocumentFactory();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }

    // Optional: Method to handle storing the document to a specific location
    private void storeDocument(File file) throws IOException {
        // You can implement file storage logic here (e.g., saving to cloud, local storage, etc.)
        // Example of storing in a local directory:
        File destinationDir = new File("/path/to/save/documents");
        if (!destinationDir.exists()) {
            destinationDir.mkdirs(); // Create directories if not exist
        }
        
        // Move the generated file to the desired directory (optional)
        file.renameTo(new File(destinationDir, file.getName()));
    }
}
