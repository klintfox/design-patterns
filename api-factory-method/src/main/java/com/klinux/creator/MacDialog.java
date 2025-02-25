package com.klinux.creator;

import com.klinux.model.Button;
import com.klinux.model.MacButton;

public class MacDialog extends Dialog {

    @Override
    public Button createButton() {
        return new MacButton();  // Creates MacButton
    }
}
