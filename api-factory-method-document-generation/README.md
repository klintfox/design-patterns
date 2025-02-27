# Document Generation Service

## Overview

This project demonstrates a **Factory Method design pattern** to generate documents in different formats (PDF, Excel, and Word). The application uses **Spring Boot** for creating a REST API where clients can send a request to generate documents in different formats.

### Key Components
1. **Factory Method Pattern**: 
   - The Factory Method is used to create the right type of document (PDF, Excel, Word) based on the user’s input.
   - Each document type (PDF, Excel, Word) is created using a specific Factory class.
   - This ensures that the correct document format is generated based on the type.

2. **Document Generation Service**: 
   - A service layer (`DocumentGenerationService`) handles the business logic for generating documents.
   - It uses the appropriate Factory class to generate the document and returns the file name of the generated document.

3. **Controller**: 
   - The `DocumentController` is a REST controller that receives HTTP requests to generate documents.
   - It takes the document type (PDF, Excel, or Word) and content from the user and calls the service to generate the document.

## Project Structure

```plaintext
├───controller
│       DocumentController.java          # Handles HTTP requests
│
├───document
│       Document.java                    # Document interface (abstract)
│       ExcelDocument.java               # Concrete implementation for Excel document
│       PDFDocument.java                 # Concrete implementation for PDF document
│       WordDocument.java                # Concrete implementation for Word document
│
├───factory
│       DocumentFactory.java             # Abstract Factory class for document generation
│       ExcelDocumentFactory.java        # Concrete factory for Excel document
│       PDFDocumentFactory.java          # Concrete factory for PDF document
│       WordDocumentFactory.java         # Concrete factory for Word document
│
├───service
│       DocumentGenerationService.java   # Service that contains business logic for document generation
│
└───ApiFactoryMethodDocumentGenerationApplication.java  # Main Spring Boot application class
```
## Postman
- Url: 
```
http://localhost:8080/documents/generate
```
[Send and Download]()