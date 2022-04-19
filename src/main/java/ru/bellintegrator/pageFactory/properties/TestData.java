package ru.bellintegrator.pageFactory.properties;

import org.aeonbits.owner.ConfigFactory;

/**
 * @author valit
 * date     19.04.2022
 * @project UITestYandexMarket
 */

public class TestData {

    public static PropsUrl propsUrl = ConfigFactory.create(PropsUrl.class);
    public static PropsDriver propsDriver = ConfigFactory.create(PropsDriver.class);

}
