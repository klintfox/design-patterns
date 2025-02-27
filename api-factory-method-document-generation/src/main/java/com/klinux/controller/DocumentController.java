package com.klinux.controller;
import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klinux.service.DocumentGenerationService;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentGenerationService documentGenerationService;

    public DocumentController(DocumentGenerationService documentGenerationService) {
        this.documentGenerationService = documentGenerationService;
    }

    @PostMapping("/generate")
    public ResponseEntity<FileSystemResource> generateDocument(@RequestParam String type, @RequestParam String content) {
        try {
            // Delegate document generation to the service
            String fileName = documentGenerationService.generateDocument(type, content);
            
            // Get the file created by the factory
            File generatedFile = new File(fileName);
            FileSystemResource fileResource = new FileSystemResource(generatedFile);

            // Return the file as a response to the client
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + generatedFile.getName());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileResource);
        } catch (Exception e) {
            // Return error message if document generation fails
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}