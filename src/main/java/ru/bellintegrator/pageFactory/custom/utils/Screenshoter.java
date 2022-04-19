package ru.bellintegrator.pageFactory.custom.utils;


import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author valit
 * date     19.04.2022
 * @project UITestYandexMarket
 */

public class Screenshoter {

    @Attachment
    public static byte[] getScreen(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/main/resources/screen.png"));
            return Files.readAllBytes(Paths.get("src/main/resources", "screen.png"));
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Не удалось сохранить файл на диск");
        }
        return new byte[0];
    }

    @Attachment
    public static byte[] getScreen(WebDriver driver, WebElement element) {
        Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(element).build().perform();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/main/resources/screen.png"));
            return Files.readAllBytes(Paths.get("src/main/resources", "screen.png"));
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Не удалось сохранить файл на диск");
        }
        return new byte[0];
    }





























}
