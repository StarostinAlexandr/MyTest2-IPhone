package practica;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends WebDriverSettings {

    @Test
    @Description(value = "В яндекс маркете выбрать телефоны." +
            " Установить фильтр (checkbox) iOS (айфон)." +
            " Убедится что на всех страницах (если их несколько), присутствуют только айфоны. ")
    public void testPOMarketYandexTelephonesCheckIPhone() {

        PageObjectMarketYandex pageObjectMarketYandex = new PageObjectMarketYandex(chromeDriver, "телефоны");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Steps.checkMarketYandexPhonesSelected(pageObjectMarketYandex.isExistsPhoneTextWhenPhonesSelected(), chromeDriver);

        pageObjectMarketYandex.setFilterCheckBoxBoxIOs();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Steps.checkSetFilterIOS(pageObjectMarketYandex.getFilterCheckBoxIOs(), chromeDriver);

        while (pageObjectMarketYandex.isExistsButtonShowMorePages()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pageObjectMarketYandex.getButtonShowMorePages().click();
        }
        pageObjectMarketYandex.collectResultByTitle();

        Steps.checkContainsName(pageObjectMarketYandex.getCollectResults(), "iphone", chromeDriver);
    }


    @Test
    @Description(value = "В яндекс маркете выбрать телефоны." +
            " Убедится что не если не выбран iOS то все телефоны не могут быть айфоны ")
    public void testPOMarketYandexTelephonesIsIPhoneNegative() {
        PageObjectMarketYandex pageObjectMarketYandex = new PageObjectMarketYandex(chromeDriver, "телефон");
        pageObjectMarketYandex.collectResultByTitle();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Steps.checkContainsNameNegative(pageObjectMarketYandex.getCollectResults(), "iphone", chromeDriver);

    }

    @Test
    @Description(value = "В яндекс маркете выбрать телефоны." +
            " Установить фильтр (checkbox) iOS (айфон)." +
            " Убедится что на всех страницах (если их несколько), присутствуют только айфоны. ")
    public void testPFMarketYandexTelephonesCheckIPhone() {
        chromeDriver.get("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?text=телефоны");
        PageFactoryMarketYandex pageFactoryYandex = PageFactory.initElements(chromeDriver, PageFactoryMarketYandex.class);

        Steps.checkMarketYandexPhonesSelected(pageFactoryYandex.isExistsPhoneTextWhenPhonesSelected(), chromeDriver);

        pageFactoryYandex.setFilterCheckBoxBoxIOs();
        Steps.checkSetFilterIOS(pageFactoryYandex.getCheckboxSetIOS(), chromeDriver);

        while (pageFactoryYandex.isExistsButtonShowMorePages()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pageFactoryYandex.buttonShowMorePages.click();
        }
        Steps.checkContainsName(pageFactoryYandex.getCollectResults(), "iphone", chromeDriver);
    }

    @Test
    @Description(value = "В яндекс маркете выбрать телефоны." +
            " Убедится что не если не выбран iOS то все телефоны не могут быть айфоны ")
    public void testPFMarketYandexTelephonesIsIPhoneNegative() {
        chromeDriver.get("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?text=телефоны");
        PageFactoryMarketYandex pageFactoryYandex = PageFactory.initElements(chromeDriver, PageFactoryMarketYandex.class);

        Steps.checkContainsNameNegative(pageFactoryYandex.getCollectResults(), "iphone", chromeDriver);
    }
}

