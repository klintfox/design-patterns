# GUI Framework  - Abstract Factory Pattern

This is a simple example demonstrating the **Abstract Factory Pattern** in a Spring Boot application. The goal of this example is to create a cross-platform GUI framework that provides platform-specific UI components, such as buttons and text fields.

## Architecture Overview

In this example, we have three platforms: **Windows**, **Mac**, and **Linux**. Each platform has its own UI components that are created using the **Abstract Factory Pattern**.

### The Structure:

- **UIFactory**: An abstract factory interface that declares methods for creating UI components (buttons and text fields).
- **Concrete Factories**: `WindowsFactory`, `MacFactory`, and `LinuxFactory` are platform-specific implementations of the `UIFactory` interface. These factories create platform-specific buttons and text fields.
- **Components**: `Button` and `TextField` are interfaces that are implemented by platform-specific components like `WindowsButton`, `MacButton`, and `LinuxButton`.
```
├───main
│   ├───java
│   │   └───com
│   │       └───klinux
│   │           │   ApiAbstractFactoryGuiFrameworkApplication.java
│   │           │
│   │           └───gui
│   │               ├───components
│   │               │       Button.java
│   │               │       LinuxButton.java
│   │               │       LinuxTextField.java
│   │               │       MacButton.java
│   │               │       MacTextField.java
│   │               │       TextField.java
│   │               │       WindowsButton.java
│   │               │       WindowsTextField.java
│   │               │
│   │               └───factory
│   │                       LinuxFactory.java
│   │                       MacFactory.java
│   │                       UIFactory.java
│   │                       WindowsFactory.java
│   │
│   └───resources
│       │   application.properties
│       │
│       ├───static
│       └───templates
└───test
    └───java
        └───com
            └───klinux
                    ApiAbstractFactoryGuiFrameworkApplicationTest.java
```

### Example Usage:

1. **Windows**: When the Windows factory is used, it creates Windows-specific buttons and text fields.
2. **Mac**: Similarly, when the Mac factory is used, it creates Mac-specific buttons and text fields.
3. **Linux**: Linux components are created when the Linux factory is used.

### Running the Application:

The application creates and renders buttons and text fields for each platform in sequence, showing how the abstract factory pattern allows us to switch between different sets of UI components based on the platform.

### How to Run:

1. Clone this repository.
2. Build the application with Maven:
