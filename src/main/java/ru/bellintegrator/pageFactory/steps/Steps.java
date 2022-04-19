package ru.bellintegrator.pageFactory.steps;


import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import ru.bellintegrator.pageFactory.custom.drivers.Manager;
import ru.bellintegrator.pageFactory.custom.utils.Constants;
import ru.bellintegrator.pageFactory.pages.PageFactoryTestMarket;

import java.util.List;

/**
 * @author valit
 * date     19.04.2022
 * @project UITestYandexMarket
 */

public class Steps {

    private static PageFactoryTestMarket pageFactoryTestMarket;

    @Step("Открыте браузера со страртовой страницей yandex")
    public static void openBrowserWithYandex() {
        Manager.getCurrentDriver().get(Constants.URL);
    }

    @Step("Инициализация PageFactoryTestMarket")
    public static void initPageFactoryTestMarket() {
        pageFactoryTestMarket =
                PageFactory.initElements(Manager.getCurrentDriver(), PageFactoryTestMarket.class);
    }

    @Step("Переход по ссылке на страницу яндекс маркета")
    public static void switchToYandexMarket() {
        pageFactoryTestMarket.switchToYandexMarket();
    }

    @Step("Клик на кнопке каталог")
    public static void clickCatatlog() {
        pageFactoryTestMarket.clickCatalog();
    }

    @Step("Наведение на вкладку меню копьютеры ожидание прогрузки меню")
    public static void hoverMenuComputers() {
        pageFactoryTestMarket.hoverMenuComputers();
    }

    @Step("Клик на вкладке меню LapTops")
    public static void clickLapTops() {
        pageFactoryTestMarket.clickLapTops();
    }

    @Step("Установка занчений 'от' и 'до' в полях стоимостей")
    public static void setCosts(int from, int to) {
        pageFactoryTestMarket.setCosts(from, to);
    }

    @Step("Нажатие на кнопку все произодители")
    public static void showAllProducer() {
        pageFactoryTestMarket.showAllProducer();
    }

    @Step("Установка checkButton для поиска производителей переданных в листе")
    public static void setProducers(List<String> producers) {
        pageFactoryTestMarket.setProducers(producers);
    }

    @Step("Установка пагинации на 12")
    public static void setTwelvePagination() {
        pageFactoryTestMarket.setTwelve();
    }

    @Step("Получение количества показынных элементов из результата поиска")
    public static int getSearchingSizeResult() {
        return pageFactoryTestMarket.getSearchResultNumber();
    }

    @Step("Сохранение название первого элемента")
    public static void saveFirstElementName() {
        pageFactoryTestMarket.saveFirstElement();
    }

    @Step("Поиск по названию сохраненного элемента")
    public static void sendKeysAndPressButton() {
        pageFactoryTestMarket.sendKeysAndPressButton();
    }

    @Step("Проверка на содержание результатов поиска на содержания искомого названия")
    public static boolean checkResult() {
        return pageFactoryTestMarket.checkResults();
    }
}
