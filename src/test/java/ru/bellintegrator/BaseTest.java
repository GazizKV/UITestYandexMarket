package ru.bellintegrator;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.bellintegrator.pageFactory.custom.drivers.Manager;

import java.util.concurrent.TimeUnit;

/**
 * @author valit
 * date     13.04.2022
 * @project UITestYandexMarket
 */
public class BaseTest {
    /**
     * Браузер
     */
    protected WebDriver webDriver;
    /**
     * Открытие браузера и ожидание прогрузки элементов и скриптов
     */
    @BeforeEach
    public void beforeEachOpenGoogleChrome() {
        /*
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
         */
        Manager.initChrome();
        webDriver = Manager.getCurrentDriver();
    }
    /**
     * Закрытие браузера
     */
    @AfterEach
    public void afterEachQuiteGoogleChrome() {
//        webDriver.quit();
//        Manager.killCurrentDriver();
    }

}
