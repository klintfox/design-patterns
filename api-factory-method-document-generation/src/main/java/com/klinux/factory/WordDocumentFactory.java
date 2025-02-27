package com.klinux.factory;

import com.klinux.document.Document;
import com.klinux.document.WordDocument;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}