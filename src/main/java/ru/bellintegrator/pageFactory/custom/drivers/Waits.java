package ru.bellintegrator.pageFactory.custom.drivers;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.bellintegrator.pageFactory.custom.utils.Constants;

/**
 * @author valit
 * date     19.04.2022
 * @project UITestYandexMarket
 */

public class Waits {
    public static WebDriverWait wait = new WebDriverWait(
            Manager.getCurrentDriver(), Constants.DEFAULT_TIMEOUT
    );
    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void waitUntilElementNotExist(String xpath) {
        int timer = 0;
        for(; timer <= Constants.DEFAULT_TIMEOUT; ++timer) {
            if (Manager.getCurrentDriver().findElement(By.xpath(xpath)).getSize().height == 0) {
                break;
            }
            sleep(1);
        }
        if (timer == Constants.DEFAULT_TIMEOUT) {
            throw new TimeoutException("Элемент с седектором " + xpath + " не исчез за " + Constants.DEFAULT_TIMEOUT + " секунд");
        }
    }
    public static void waitUntilElementRealyClicable(String xpath) {
        Waits.wait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                driver.findElement(By.xpath(xpath)).click();
            } catch (ElementClickInterceptedException e) {
                return false;
            }
            return true;
        });
    }
    public static void waitUntilElementClickable(String xpath) {
        new WebDriverWait(Manager.getCurrentDriver(), Constants.DEFAULT_TIMEOUT).until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
        );
    }
    public static void waitUntilElementPresents(String xpath) {
        Waits.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
    public static void waitUntilAttributeWillBe(WebElement element, String attribute, String value) {
        Waits.wait.until((ExpectedCondition<Boolean>) driver -> element.getAttribute(attribute).contains(value));
    }
    public static void waitUntilElementTextContainsByLocator(By locator, String text) {
        Waits.wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    public static void waitUntilElementTextContains(WebElement element, String text) {
        Waits.wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
