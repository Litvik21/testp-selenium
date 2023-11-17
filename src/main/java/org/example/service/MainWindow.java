package org.example.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface MainWindow {
    void chooseVerificationWay(WebDriver driver, WebDriverWait wait);

    void chooseWallet(WebDriver driver, WebDriverWait wait);

    void getPass(WebDriver driver, WebDriverWait wait);
}
