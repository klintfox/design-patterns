package com.klinux.gui.factory;

import com.klinux.gui.components.Button;
import com.klinux.gui.components.TextField;

public interface UIFactory {
    Button createButton();
    TextField createTextField();
}