package org.example.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Frame {
    void acceptTermsAndConditions(WebDriver driver, WebDriverWait wait);

    void confirmTransfer(WebDriver driver, WebDriverWait wait);
}
