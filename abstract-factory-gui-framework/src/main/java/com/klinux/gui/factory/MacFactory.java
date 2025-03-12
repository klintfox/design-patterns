package com.klinux.gui.factory;

import com.klinux.gui.components.Button;
import com.klinux.gui.components.MacButton;
import com.klinux.gui.components.MacTextField;
import com.klinux.gui.components.TextField;
import org.springframework.stereotype.Component;

@Component
public class MacFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}