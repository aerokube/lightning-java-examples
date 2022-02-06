package com.aerokube.lightning.examples;

import com.aerokube.lightning.Capabilities;
import com.aerokube.lightning.WebDriver;
import com.aerokube.lightning.extensions.MoonCommands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This example demonstrates how to use powerful clipboard features of Moon
 */
public class MoonClipboard {

    public static void main(String[] args) throws Exception {

        Capabilities capabilities = Capabilities.create().chrome();
        try (WebDriver webDriver = WebDriver.create("http://localhost:4444/wd/hub", capabilities)) {

            String text = webDriver.extension(MoonCommands.class)
                    .updateClipboardText("test-value")
                    .getClipboardText();
            System.out.printf("clipboard value is = %s\n", text);

            Path image = Paths.get("image.png");
            byte[] clipboardImage = webDriver.extension(MoonCommands.class)
                    .updateClipboardImage(image).getClipboardImage();
            Files.write(Paths.get("clipboard-image.png"), clipboardImage);
        }

    }

}
