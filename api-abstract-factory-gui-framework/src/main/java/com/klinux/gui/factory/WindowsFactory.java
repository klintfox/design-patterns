package com.klinux.gui.factory;

import com.klinux.gui.components.Button;
import com.klinux.gui.components.TextField;
import com.klinux.gui.components.WindowsButton;
import com.klinux.gui.components.WindowsTextField;
import org.springframework.stereotype.Component;

@Component
public class WindowsFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}