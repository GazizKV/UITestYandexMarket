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
        "file:url.properties"
})
public interface PropsUrl extends Config {

    @Key("base.url.citylink")
    String baseURLCitylink();

}
