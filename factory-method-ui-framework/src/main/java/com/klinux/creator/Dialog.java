package com.klinux.creator;

import com.klinux.model.Button;

public abstract class Dialog {
    
	// Factory Method
    public abstract Button createButton();

    public void renderButton() {
        Button button = createButton();  // Using the factory method
        button.render();
        button.onClick();
    }
}
