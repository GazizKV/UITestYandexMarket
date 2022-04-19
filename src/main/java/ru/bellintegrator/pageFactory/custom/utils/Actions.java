package ru.bellintegrator.pageFactory.custom.utils;


import org.openqa.selenium.By;
import ru.bellintegrator.pageFactory.custom.drivers.Manager;

import java.util.function.Consumer;

/**
 * @author valit
 * date     19.04.2022
 * @project UITestYandexMarket
 */

public class Actions {

    public static org.openqa.selenium.interactions.Actions action;

    public static Consumer<By> hover = (By by) -> {
        action.moveToElement(Manager.getCurrentDriver().findElement(by)).perform();
    } ;

}
