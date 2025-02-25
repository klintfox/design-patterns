package com.klinux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klinux.log.LogManager;

@SpringBootApplication
public class ApiSingletonLoggerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiSingletonLoggerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
        // Get the single instance of LogManager and log some messages
        LogManager logManager = LogManager.getInstance();
        logManager.log("Application Started");
        logManager.log("Performing some operation...");
        logManager.log("Application Finished");
    }

}
