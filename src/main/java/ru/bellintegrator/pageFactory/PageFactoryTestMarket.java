package ru.bellintegrator.pageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

/**
 * @author valit
 * date     13.04.2022
 * @project UITestYandexMarket
 */

public class PageFactoryTestMarket {

    /**
     * Драйвер браузера
     */
    private WebDriver webDriver;

    /**
     * Драйвер ожидания события
     */
    private WebDriverWait webDriverWait;

    /**
     * Элемент DOM ссылка на яндекс маркет
     */
    @FindBy(how = How.XPATH, using = "//a[@data-id='market']")
    private WebElement market;

    /**
     * Элемент DOM кнопка каталог
     */
    @FindBy(how = How.XPATH, using = "//button[@aria-label='Каталог']")
    private WebElement catalog;

    /**
     * Элемент DOM вкладка меню каталог "Компьютеры"
     */
    @FindBy(how = How.XPATH, using = "//span[text() = 'Компьютеры']")
    private WebElement computers;

    /**
     * Элемент DOM вкладка меню компьютеры "Ноутбуки"
     */
    @FindBy(how = How.XPATH, using = "//a[text() = 'Ноутбуки']")
    private WebElement lapTops;

    /**
     * Элемент DOM input для указания цены "ОТ"
     */
    @FindBy(how = How.XPATH, using = "//input[@name='Цена от']")
    private WebElement costFrom;

    /**
     * Элемент DOM input для указания цены "ДО"
     */
    @FindBy(how = How.XPATH, using = "//input[@name='Цена до']")
    private WebElement costTo;

    /**
     * Элемент DOM кнопка для списка производителей
     */
    @FindBy(how = How.XPATH, using = "//legend[text()='Производитель']/..//button")
    private WebElement producerShowAll;

    /**
     * Элементы DOV не упорядоченный список производителей
     * оборудования с чекбоксами
     */
    @FindBy(how = How.XPATH, using = "//legend[text()='Производитель']/..//input[@type='checkbox']/..")
    private List<WebElement> producersList;

    /**
     * Элемент DOM text() = "Показывать по 'number'" показывает действительное значение эелемента
     */
    @FindBy(how = How.XPATH, using = "//button[@aria-haspopup='true']")
    private WebElement currentPagination;

    /**
     * Элемент DOM text() = "Показывать по 48"
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Показывать по 12']")
    private WebElement pagination12;

    /**
     * Элемент DOM text() = "Показывать по 12"
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Показывать по 48']")
    private WebElement pagination48;

    /**
     * Список эелементов результата поиска
     */
    @FindBy(how = How.XPATH, using = "//article[@data-autotest-id='product-snippet']")
    private List<WebElement> searchResultList;

    /**
     * Первое значение в списке результатов поиска
     */
    private String nameOfFirstElement;

    /**
     * input для ввода искомого товара значения ключа
     */
    @FindBy(how = How.XPATH, using = "//article[@data-autotest-id='product-snippet']")
    private WebElement inputSearch;

    /**
     * button submit для поиска
     */
    @FindBy(how = How.XPATH, using = "//button[@data-r='search-button']")
    private WebElement searchButton;

    /**
     * Конструктор PageFactory
     *
     * @param webDriver - драйвер браузера
     */
    public PageFactoryTestMarket(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 15);
    }

    /**
     * Переход на вкладку яндекс маркета
     *
     * @return boolean по рузультату открытия яндекс маркета
     */
    public boolean switchToYandexMarket() {
        market.click();
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> tabsList = new LinkedList<>(webDriver.getWindowHandles());
        if (tabsList.size() > 1) {
            webDriver.switchTo().window(tabsList.get(tabsList.size() - 1));
            return true;
        }
        return false;
    }

    /**
     * клик по кнопке каталог
     */
    public void clickCatalog() {
        catalog.click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(computers));
    }

    public void hoverMenuComputers() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(computers).build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(lapTops));
    }

    public void clickLapTops() {
        Actions actions = new Actions(webDriver);
        actions.click(lapTops).build().perform();
    }

    public void setCosts(int from, int to) {
        costFrom.click();
        costFrom.sendKeys("10000");
        costTo.click();
        costTo.sendKeys("900000");
    }

    public void showAllProducer() {
        producerShowAll.click();
        webDriverWait.until(
                ExpectedConditions
                        .visibilityOfElementLocated
                                (By.xpath("//legend[text()='Производитель']/.."))
        );
    }

    public void setProducers(List<String> stringsProducer) {
        Actions actions = new Actions(webDriver);
        stringsProducer.forEach(producer -> {
            for (int i = 0; i < producersList.size(); i++) {
                if (producersList.get(i).getText().contains(producer)) {
                    actions
                            .moveToElement(producersList.get(i))
                            .click(producersList.get(i))
                            .build().perform();
                }
            }
        });

        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//article[@data-autotest-id='product-snippet']"),
                12
        ));
    }

    public void setTwelve() {
        Actions actions = new Actions(webDriver);
        actions
                .moveToElement(currentPagination)
                .click(currentPagination)
                .build().perform();
        currentPagination.click();
        webDriverWait
                .until(ExpectedConditions
                        .attributeContains(
                                currentPagination,
                                "aria-expanded",
                                "true"
                        ));
        actions.click(pagination12).build().perform();
        webDriverWait
                .until(
                        ExpectedConditions.numberOfElementsToBe(
                                By.xpath("//article[@data-autotest-id='product-snippet']"),
                                12
                        ));
    }

    public int checkTwelve() {
        return searchResultList.size();
    }

    public void saveFirstElement() {
        nameOfFirstElement = searchResultList.get(0).findElement(By.xpath(
                "//h3/.//span"
        )).getText();
    }

    public void sendKeysAndPressButton() {
        Actions actions = new Actions(webDriver);
        actions
                .click(inputSearch)
                .sendKeys(nameOfFirstElement)
                .build().perform();
        actions.click(searchButton).build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//article[@data-autotest-id='product-snippet']")
        ));
    }


    public boolean checkResults() {
        return searchResultList.stream().anyMatch(webElement ->
                webElement.getText().contains(nameOfFirstElement)
        );
    }
}
