package com.klinux.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {

    // Logger instance using SLF4J
    private static final Logger logger = LoggerFactory.getLogger(LogManager.class);

    // The single instance of the class
    private static LogManager instance;

    // Private constructor to prevent instantiation from other classes
    private LogManager() {}

    // Method to return the single instance, with lazy initialization
    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    // Method to log messages to the console and file
    public void log(String message) {
        // Log to the console
        logger.info(message);

        // Optionally log to a file (Spring Boot automatically handles file logging based on configuration)
    }
}