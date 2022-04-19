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
import java.util.logging.Logger;

/**
 * @author valit
 * date     13.04.2022
 * @project UITestYandexMarket
 */

public class PageFactoryTestMarket {

    /**
     * Логгер
     */
    Logger logger = Logger.getLogger(PageFactoryTestMarket.class.getName());

    /**
     * Драйвер браузера
     */
    private WebDriver webDriver;

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
     * Элемент DOM поле результатов поиска
     */
    @FindBy(how = How.XPATH, using = "//div[@data-zone-name='snippetList']")
    private WebElement searchResultField;

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
     * Переход на вкладку яндекс маркета
     *
     * @return boolean по рузультату открытия яндекс маркета
     */
    public boolean switchToYandexMarket() {
        market.click();
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
        logger.info("Click 'Каталог'");
        catalog.click();
    }

    /**
     * Навередение на элемент меню каталога "Компьютеры"
     */
    public void hoverMenuComputers() {
        logger.info("Hover 'компьютеры'");
        Actions actions = new Actions(webDriver);
        actions.moveToElement(computers).build().perform();
    }

    /**
     * Клик на элемент меню компьютеры "Ноутбуки"
     */
    public void clickLapTops() {
        logger.info("Click ноутбуки");
        Actions actions = new Actions(webDriver);
        actions.click(lapTops).build().perform();
    }

    /**
     * Выставление цен от "From" до "To"
     */
    public void setCosts(int from, int to) {
        logger.info("Set costs");
        costFrom.sendKeys(String.valueOf(from));
        costTo.sendKeys(String.valueOf(to));
    }

    /**
     * Показать полный список производителей
     */
    public void showAllProducer() {
        logger.info("Show all producer");
        Actions actions = new Actions(webDriver);
        actions.click(producerShowAll);

    }

    /**
     * Отметить выбрано checkBox checked для списка stringsProducer
     */
    public void setProducers(List<String> stringsProducer) {
        logger.info("Set producers");
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
    }

    /**
     * Выставить пагинацию с 48 на 12
     */
    public void setTwelve() {
        Actions actions = new Actions(webDriver);

        webDriverWait.until(ExpectedConditions.visibilityOf(searchResultField));
        logger.info("Move to " + currentPagination.getText() + " and click");
        actions
                .click(currentPagination)
                .build().perform();

        logger.info("Move to " + pagination12 + " and click");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(pagination12));

        actions
                .click(pagination12)
                .build().perform();

    }

    /**
     * Геттер для количества товара показанного на странице в результатах поиска (пагинация)
     *
     * @return int колечество товаров показанных на странице
     */
    public int getSearchResultNumber() {
        logger.info("Возварат количество товаров на странице");
        return searchResultList.size();
    }

    /**
     * Сохранение первого элемента в переменную nameOfFirstElement
     */
    public void saveFirstElement() {
        logger.info("Сохранение первого элемента в переменную nameOfFirstElement");
        nameOfFirstElement = searchResultList.get(0).findElement(By.xpath(
                "//h3/.//span"
        )).getText();
    }

    /**
     * Поиск товара по названию сохраненного элемента
     */
    public void sendKeysAndPressButton() {
        logger.info("Поиск товара по названию сохраненного элемента");
        Actions actions = new Actions(webDriver);
        actions
                .click(inputSearch)
                .sendKeys(nameOfFirstElement)
                .build().perform();
        actions.click(searchButton).build().perform();
    }

    /**
     * Проверка результатов поиска на содержание названия нужного элемента
     *
     * @return boolean возвращает рузультат проверки в булеан
     */
    public boolean checkResults() {
        logger.info("Проверка результатов поиска на содержание названия нужного элемента");
        return searchResultList.stream().anyMatch(webElement ->
                webElement.getText().contains(nameOfFirstElement)
        );
    }
}
