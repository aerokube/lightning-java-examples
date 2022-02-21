package com.aerokube.lightning.examples;

import com.aerokube.lightning.Capabilities;
import com.aerokube.lightning.WebDriver;

import java.net.http.HttpClient;
import java.time.Duration;

/**
 * This example demonstrates how to override built-in http client parameters
 */
public class HttpClientOverride {

    public static void main(String[] args) {
        String baseUri = "http://localhost:4444/wd/hub";

        Capabilities capabilities = Capabilities.create().chrome();

        HttpClient.Builder httpClientBuilder = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(60))
                .followRedirects(HttpClient.Redirect.NEVER);

        try (WebDriver driver = WebDriver.create(baseUri, capabilities, httpClientBuilder)) {
            driver.navigation().navigate("https://example.com");
        }
    }

}
