package ru.bellintegrator.pageFactory.properties;


import org.aeonbits.owner.Config;

/**
 * @author valit
 * date     19.04.2022
 * @project UITestYandexMarket
 */

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:driver.properties"
})
public interface PropsDriver extends Config {

    @Key("default.timeout")
    int defaultTimeout();

    @Key("address.chrome.driver")
    String addressChromeDriver();
}
