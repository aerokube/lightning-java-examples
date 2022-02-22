package com.aerokube.lightning.examples;

import com.aerokube.lightning.Capabilities;
import com.aerokube.lightning.WebDriver;
import com.aerokube.lightning.extensions.MoonCommands;

import java.util.List;

/**
 * This example demonstrates how to access downloaded files in Moon
 */
public class MoonDownload {

    public static void main(String[] args) throws Exception {

        Capabilities capabilities = Capabilities.create().chrome();
        try (WebDriver driver = WebDriver.create("http://localhost:4444/wd/hub", capabilities)) {

            List<String> files = driver.extension(MoonCommands.class).listFiles();
            System.out.println("Available files:");
            files.forEach(System.out::println);

            byte[] contents = driver.extension(MoonCommands.class).downloadFile("myfile.txt");
            System.out.printf("contents:\n %s", new String(contents));

            driver.extension(MoonCommands.class).deleteFile("myfile.txt");

        }

    }

}
