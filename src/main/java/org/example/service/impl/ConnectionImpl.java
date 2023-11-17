package org.example.service.impl;

import org.example.service.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConnectionImpl implements Connection {
    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "selenium/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // For remote debug of the browser, use following command for terminal (use right path of your computer):
        // "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome" --remote-debugging-port=9222

        // options.setExperimentalOption("debuggerAddress", "localhost:9222");
        // options.addArguments("--ignore-certificate-errors");

        // Connecting the Google Chrome profile
        options.addArguments("--user-data-dir=/Users/litvik/Library/Application Support/Google/Chrome/Profile 1");
        WebDriver driver = new ChromeDriver(options);

        // Go to the desired page
        driver.get("https://getpass.civic.com/status?chain=polygon");
        return driver;
    }
}
