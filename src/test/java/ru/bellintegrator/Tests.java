package ru.bellintegrator;


import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.bellintegrator.pageFactory.PageFactoryTestMarket;

import java.util.List;

/**
 * @author  valit
 * date     13.04.2022
 * @project UITestYandexMarket
 * @version 1.0
 */
public class Tests extends BaseTest {


    @Feature("Тестирование яндекс маркета")
    @DisplayName("Тестирование параметров поиска Яндекс маркета")
    @ParameterizedTest
    @MethodSource("ru.bellintegrator.pageFactory.helpers.DataProvider#provideArguments")
    public void test(String URL, int from, int to, List<String> producers) {
        webDriver.get(URL);
        PageFactoryTestMarket pageFactoryTestMarket =
                PageFactory.initElements(webDriver, PageFactoryTestMarket.class);
        pageFactoryTestMarket.switchToYandexMarket();
        pageFactoryTestMarket.clickCatalog();
        pageFactoryTestMarket.hoverMenuComputers();
        pageFactoryTestMarket.clickLapTops();
        pageFactoryTestMarket.setCosts(from, to);
        pageFactoryTestMarket.showAllProducer();
        pageFactoryTestMarket.setProducers(producers);
        pageFactoryTestMarket.setTwelve();
        Assertions.assertTrue(
                pageFactoryTestMarket.getSearchResultNumber() == 12,
                "Список резултатов поиска не равен 12"
        );
        pageFactoryTestMarket.saveFirstElement();
        pageFactoryTestMarket.sendKeysAndPressButton();
        Assertions.assertTrue(
                pageFactoryTestMarket.checkResults(),
                "Результаты поиска не содержат навания " +
                        "раннее сохраненного первого элемента из поисковой выдачи" +
                        "по дефолту"
        );

    }

}
