package com.klinux.factory;

import com.klinux.document.Document;
import com.klinux.document.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}