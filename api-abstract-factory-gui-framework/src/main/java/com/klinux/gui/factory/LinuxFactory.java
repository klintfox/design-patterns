package com.klinux.gui.factory;

import com.klinux.gui.components.Button;
import com.klinux.gui.components.LinuxButton;
import com.klinux.gui.components.LinuxTextField;
import com.klinux.gui.components.TextField;

import org.springframework.stereotype.Component;

@Component
public class LinuxFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
}