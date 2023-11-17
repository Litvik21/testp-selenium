package org.example.service.impl;

import org.example.service.MainWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainWindowImpl implements MainWindow {
    @Override
    public void chooseVerificationWay(WebDriver driver, WebDriverWait wait) {
        // Select a verification option
        WebElement dropdownButton = driver.findElement(By.id("headlessui-listbox-button-:r0:"));
        dropdownButton.click();

        // Selecting verification via captcha
        WebElement optionCaptcha = driver.findElement(By.xpath("//span[text()='CAPTCHA Verification']"));
        optionCaptcha.click();
    }

    @Override
    public void chooseWallet(WebDriver driver, WebDriverWait wait) {
        // Wallet connection
        WebElement connectButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sc-csKJRI.erRRBL")));
        connectButton.click();

        // Choosing a wallet
        WebElement metaMaskButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='rk-wallet-option-rainbow']")));
        metaMaskButton.click();
    }

    @Override
    public void getPass(WebDriver driver, WebDriverWait wait) {
        // Pressing the button to go through confirmation
        WebElement getPass = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.status-button.NOT_REQUESTED")));
        getPass.click();
    }
}
