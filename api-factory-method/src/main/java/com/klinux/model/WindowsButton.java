package com.klinux.model;

public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering a Windows button.");
    }

    @Override
    public void onClick() {
        System.out.println("Windows Button clicked.");
    }
}