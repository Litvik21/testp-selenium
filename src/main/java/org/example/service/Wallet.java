package org.example.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Wallet {
    void connectToWallet(WebDriver driver, WebDriverWait wait, String mainWindow);

    void confirmConnection(WebDriver driver, WebDriverWait wait, String mainWindow);
}
