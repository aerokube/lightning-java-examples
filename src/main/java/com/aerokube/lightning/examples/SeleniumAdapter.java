package com.aerokube.lightning.examples;

import com.aerokube.lightning.Capabilities;
import com.aerokube.lightning.adapter.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This example demonstrates how to use Lightning in your existing Selenium tests
 */
public class SeleniumAdapter {

    public static void main(String[] args) throws Exception {
        String baseUri = "http://localhost:4444/wd/hub";

        Capabilities capabilities = Capabilities.create().chrome();
        try (com.aerokube.lightning.WebDriver lightningWebDriver = com.aerokube.lightning.WebDriver.create(baseUri, capabilities)){
            // This is where Lightning client is converted to Selenium client
            WebDriver driver = new SeleniumWebDriver(lightningWebDriver);

            // Regular Selenium code
            driver.get("https://example.com");
            WebElement input = driver.findElement(By.cssSelector("input[type=file]"));
            input.sendKeys("some-value");
        }

    }

}
