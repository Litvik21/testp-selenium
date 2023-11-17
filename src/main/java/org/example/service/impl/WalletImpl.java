package org.example.service.impl;

import org.example.service.Wallet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Scanner;
import java.util.Set;

public class WalletImpl implements Wallet {
    @Override
    public void connectToWallet(WebDriver driver, WebDriverWait wait, String mainWindow) {
        // Catching opening of a new window (wallet)
        wait.until(d -> driver.getWindowHandles().size() == 2);

        // Switching to the wallet window
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String window : allWindowHandles) {
            if (!window.equals(mainWindow)) {
                // Switching to the wallet window
                driver.switchTo().window(window);

                // Entering the wallet password
                WebElement textField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='password-input']")));
                textField.sendKeys("qwertyPOR321");

                // Unlock wallet
                WebElement unlockBth = driver.findElement(By.cssSelector("[data-testid='unlock-button']"));
                unlockBth.click();

                // Confirmation of wallet connection
                WebElement nextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='accept-request-button']")));
                wait.until(ExpectedConditions.elementToBeClickable(nextButton));
                nextButton.click();
            }
        }
    }

    @Override
    public void confirmConnection(WebDriver driver, WebDriverWait wait, String mainWindow) {
        // Catching opening of a new window (wallet)
        wait.until(d -> driver.getWindowHandles().size() == 2);

        // Switching to the wallet window
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                // Switching to the wallet window
                driver.switchTo().window(window);

                // Confirmation of request
                WebElement signMess = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='accept-request-button']")));
                signMess.click();

                // Captcha Resolver.
                // WebElement captchaButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='captcha-solver-info' and text()='Решить с 2Captcha']")));
                // captchaButton.click();

                // Since the extension for automatic captcha solving does not work - we simulate
                // a delay while solving the captcha, after solving the captcha - enter something
                // in the console to continue the program.
                System.out.println("Pass the captcha to continue, after this just type anything here: ");

                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                break;
            }
        }
    }
}
