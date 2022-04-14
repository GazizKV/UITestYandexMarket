package ru.bellintegrator.pageFactory.helpers;


import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author valit
 * date     13.04.2022
 * @project UITestYandexMarket
 */

public class DataProvider {

    public static Stream<Arguments> provideArguments() {
        List<String> producers = new LinkedList<>(
                List.of("HP", "Lenovo")
        );
        return Stream.of(
                Arguments.of("https://www.yandex.ru", 10000, 900000, producers)
        );
    }
}
