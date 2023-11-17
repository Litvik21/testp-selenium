package org.example;

import org.example.service.*;
import org.example.service.impl.ConnectionImpl;
import org.example.service.impl.FrameImpl;
import org.example.service.impl.MainWindowImpl;
import org.example.service.impl.WalletImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    private static final Connection connection = new ConnectionImpl();
    private static final MainWindow mainWind = new MainWindowImpl();
    private static final Wallet wallet = new WalletImpl();
    private static final Frame frame = new FrameImpl();

    public static void main(String[] args) {
        // Connecting the driver and navigating to the desired page
        WebDriver driver = connection.getDriver();
        // Declaration of delay
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Saving the name of the main page
        String mainWindow = driver.getWindowHandle();

        // Choose verification way
        mainWind.chooseVerificationWay(driver, wait);

        // Choose wallet
        mainWind.chooseWallet(driver, wait);

        // Using separate method for better reading
        wallet.connectToWallet(driver, wait, mainWindow);

        // Switching to the main window
        driver.switchTo().window(mainWindow);

        mainWind.getPass(driver, wait);

        // Switch to the frame of the desired window
        driver.switchTo().frame(0);

        frame.acceptTermsAndConditions(driver, wait);

        // Using separate method for better reading
        wallet.confirmConnection(driver, wait, mainWindow);

        // Switching to the main window
        driver.switchTo().window(mainWindow);

        // Switching to the desired frame
        driver.switchTo().frame(0);

        frame.confirmTransfer(driver, wait);
    }
}