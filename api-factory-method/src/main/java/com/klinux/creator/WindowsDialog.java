package com.klinux.creator;

import com.klinux.model.Button;
import com.klinux.model.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();  // Creates WindowsButton
    }
}