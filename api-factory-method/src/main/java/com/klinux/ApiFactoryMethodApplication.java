package com.klinux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klinux.creator.Dialog;
import com.klinux.creator.MacDialog;
import com.klinux.creator.WindowsDialog;

@SpringBootApplication
public class ApiFactoryMethodApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiFactoryMethodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Simulate the environment (could be based on OS)
		String os = "Windows"; // Change this to "Mac" to test MacDialog

		Dialog dialog;

		if (os.equals("Windows")) {
			dialog = new WindowsDialog();
		} else {
			dialog = new MacDialog();
		}

		dialog.renderButton(); // Factory Method will create the appropriate button
	}

}
