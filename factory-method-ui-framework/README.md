# UI Framework - Factory Method Pattern

## Overview

This project demonstrates the **Factory Method Design Pattern** in Java using **Spring Boot**. The pattern is used to define an interface for creating objects, but lets subclasses decide which type of object to create. In this example, we create a simple UI framework where buttons are created dynamically depending on the operating system.

### Factory Method Pattern:

- **Product**: Defines the object that is created by the factory method (e.g., `Button`).
- **Creator (Factory)**: Defines the factory method and delegates the object creation to subclasses (e.g., `Dialog`).
- **Concrete Creator**: Subclasses of the creator that implement the factory method and decide which specific product to create (e.g., `WindowsDialog` and `MacDialog`).
- **Client Code**: Uses the factory to create the objects and interact with them.

## Key Concepts

### Product: `Button`

An interface that defines the operations that every button must implement.

```java
public interface Button {
    void render();
    void onClick();
}
```

### Concrete Products: WindowsButton and MacButton
Two concrete implementations of the Button interface:

- **WindowsButton** renders a Windows-style button.
- **MacButton* renders a Mac-style button.

```java 
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

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Mac button.");
    }

    @Override
    public void onClick() {
        System.out.println("Mac Button clicked.");
    }
}
```

### Creator: Dialog
An abstract creator that defines the createButton() factory method, which subclasses will implement to create different types of buttons.
```java
public abstract class Dialog {
    public abstract Button createButton();
    
    public void renderButton() {
        Button button = createButton();
        button.render();
        button.onClick();
    }
}
```

### Concrete Creators: WindowsDialog and MacDialog
- **WindowsDialog** creates a WindowsButton.
- **MacDialog** creates a MacButton.
```java 
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();  // Creates WindowsButton
    }
}

public class MacDialog extends Dialog {
    @Override
    public Button createButton() {
        return new MacButton();  // Creates MacButton
    }
}
```
### Client Code: FactoryPatternApplication
The client determines the operating system (Windows or Mac) and creates the corresponding dialog. The renderButton() method uses the factory method to create the button and perform actions like rendering and handling clicks.
```Java
public class FactoryPatternApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        String os = "Windows";  // Change this to "Mac" to test MacDialog

        Dialog dialog;

        if (os.equals("Windows")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new MacDialog();
        }

        dialog.renderButton();  // Factory Method will create the appropriate button
    }
}
```
