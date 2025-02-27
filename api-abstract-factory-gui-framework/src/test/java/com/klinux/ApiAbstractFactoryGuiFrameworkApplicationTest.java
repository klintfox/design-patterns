package com.klinux;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.klinux.gui.components.Button;
import com.klinux.gui.components.TextField;
import com.klinux.gui.factory.LinuxFactory;
import com.klinux.gui.factory.MacFactory;
import com.klinux.gui.factory.UIFactory;
import com.klinux.gui.factory.WindowsFactory;

@SpringBootTest
public class ApiAbstractFactoryGuiFrameworkApplicationTest {

    @Autowired
    private ApiAbstractFactoryGuiFrameworkApplication guiApplication;

    @Test
    public void testWindowsFactoryCreatesCorrectComponents() {
        // Create mock factories
        UIFactory windowsFactory = mock(WindowsFactory.class);
        Button mockButton = mock(Button.class);
        TextField mockTextField = mock(TextField.class);

        // Mock the behavior of the factory
        when(windowsFactory.createButton()).thenReturn(mockButton);
        when(windowsFactory.createTextField()).thenReturn(mockTextField);

        // Inject the mock windowsFactory into the application using setter injection
        guiApplication.setWindowsFactory(windowsFactory);

        // Run the method you want to test
        try {
            guiApplication.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify that the correct platform-specific button and text field are created
        verify(windowsFactory).createButton();
        verify(windowsFactory).createTextField();
        verify(mockButton).render();
        verify(mockTextField).render();
    }

    @Test
    public void testMacFactoryCreatesCorrectComponents() {
        UIFactory macFactory = mock(MacFactory.class);
        Button mockButton = mock(Button.class);
        TextField mockTextField = mock(TextField.class);

        when(macFactory.createButton()).thenReturn(mockButton);
        when(macFactory.createTextField()).thenReturn(mockTextField);
        
        guiApplication.setMacFactory(macFactory);

        try {
            guiApplication.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(macFactory).createButton();
        verify(macFactory).createTextField();
        verify(mockButton).render();
        verify(mockTextField).render();
    }

    @Test
    public void testLinuxFactoryCreatesCorrectComponents() {
        UIFactory linuxFactory = mock(LinuxFactory.class);
        Button mockButton = mock(Button.class);
        TextField mockTextField = mock(TextField.class);

        when(linuxFactory.createButton()).thenReturn(mockButton);
        when(linuxFactory.createTextField()).thenReturn(mockTextField);
        
        guiApplication.setLinuxFactory(linuxFactory);

        try {
            guiApplication.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(linuxFactory).createButton();
        verify(linuxFactory).createTextField();
        verify(mockButton).render();
        verify(mockTextField).render();
    }
}
