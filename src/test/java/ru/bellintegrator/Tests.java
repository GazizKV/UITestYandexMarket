package ru.bellintegrator;


import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.bellintegrator.pageFactory.steps.Steps;

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
    public void test(int from, int to, List<String> producers) {
        Steps.openBrowserWithYandex();
        Steps.initPageFactoryTestMarket();
        Steps.switchToYandexMarket();
        Steps.clickCatatlog();
        Steps.hoverMenuComputers();
        Steps.clickLapTops();
        Steps.setCosts(from, to);
        Steps.showAllProducer();
        Steps.setProducers(producers);
        Steps.setTwelvePagination();
        Assertions.assertEquals(12,
                Steps.getSearchingSizeResult(),
                "Список резултатов поиска не равен 12");
        Steps.saveFirstElementName();
        Steps.sendKeysAndPressButton();
        Assertions.assertTrue(
                Steps.checkResult(),
                "Результаты поиска не содержат навания " +
                        "раннее сохраненного первого элемента из поисковой выдачи"
        );

    }

}
