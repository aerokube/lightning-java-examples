package com.aerokube.lightning.examples;

import com.aerokube.lightning.By;
import com.aerokube.lightning.Capabilities;
import com.aerokube.lightning.WebDriver;
import com.aerokube.lightning.WebElement;
import com.aerokube.lightning.extensions.MoonCapabilities;
import com.aerokube.lightning.extensions.MoonCommands;

import java.util.List;

/**
 * This example demonstrates how to use Moon context feature to use test data in browser
 */
public class MoonContext {

    public static void main(String[] args) throws Exception {

        Capabilities capabilities = Capabilities.create().chrome()
                .extension(MoonCapabilities.class).context("https://example.com/some-data.tar.gz");

        try (WebDriver driver = WebDriver.create("http://localhost:4444/wd/hub", capabilities)) {
            driver
                .navigation().navigate("https://example.com")
                .elements().findFirst(By.cssSelector("input[type=file]"))
                .sendKeys("/home/user/some-data/some-file.txt");
        }

    }

}
