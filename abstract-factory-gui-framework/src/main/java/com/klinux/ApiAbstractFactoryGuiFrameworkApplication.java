package com.klinux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klinux.gui.components.Button;
import com.klinux.gui.components.TextField;
import com.klinux.gui.factory.UIFactory;

@SpringBootApplication
public class ApiAbstractFactoryGuiFrameworkApplication implements CommandLineRunner {

	private UIFactory windowsFactory;
    private UIFactory macFactory;
    private UIFactory linuxFactory;
    
	public static void main(String[] args) {
		SpringApplication.run(ApiAbstractFactoryGuiFrameworkApplication.class, args);
	}		

    public ApiAbstractFactoryGuiFrameworkApplication(UIFactory windowsFactory, UIFactory macFactory, UIFactory linuxFactory) {
        this.windowsFactory = windowsFactory;
        this.macFactory = macFactory;
        this.linuxFactory = linuxFactory;
    }

	@Override
	public void run(String... args) throws Exception {
		// Example for Windows
		Button button = windowsFactory.createButton();
		TextField textField = windowsFactory.createTextField();
		button.render();
		textField.render();

		// Example for Mac
		button = macFactory.createButton();
		textField = macFactory.createTextField();
		button.render();
		textField.render();

		// Example for Linux
		button = linuxFactory.createButton();
		textField = linuxFactory.createTextField();
		button.render();
		textField.render();
	}
	
	public void setWindowsFactory(UIFactory windowsFactory) {
	    this.windowsFactory = windowsFactory;
	}

	public void setMacFactory(UIFactory macFactory) {
	    this.macFactory = macFactory;
	}

	public void setLinuxFactory(UIFactory linuxFactory) {
	    this.linuxFactory = linuxFactory;
	}

}
