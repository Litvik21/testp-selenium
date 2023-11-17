package org.example.service.impl;

import org.example.service.Frame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameImpl implements Frame {
    @Override
    public void acceptTermsAndConditions(WebDriver driver, WebDriverWait wait) {
        // Check the checkBox.
        WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='TERMS_AND_CONDITIONS_CHECKBOX']")));
        checkBox.click();

        // Start verification
        WebElement startVerif = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='START_BUTTON']")));
        startVerif.click();

        // Confirmation via wallet
        WebElement continueBth = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='OK_BUTTON']")));
        continueBth.click();
    }

    @Override
    public void confirmTransfer(WebDriver driver, WebDriverWait wait) {
        // Pressing the button for final confirmation
        WebElement continueBthFinal = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='OK_BUTTON']")));
        continueBthFinal.click();
    }
}
