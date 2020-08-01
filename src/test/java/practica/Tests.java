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
        Steps.checkMarketYandexPhonesSelected(pageObjectMarketYandex.isExistsPhoneTextWhenPhonesSelected(), chromeDriver);

        pageObjectMarketYandex.setFilterCheckBoxBoxIOs();
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
    @Description(value = "В яндекс маркете выбрать ынофелет." +
            " Убедится что не выбраны телефоны ")
    public void testPOMarketYandexTelephonesNegative() {
        PageObjectMarketYandex pageObjectMarketYandex = new PageObjectMarketYandex(chromeDriver, "ынофелет");
        Steps.checkMarketYandexPhonesSelectedNegative(pageObjectMarketYandex.isExistsPhoneTextWhenPhonesSelected(), chromeDriver);

    }

    @Test
    @Description(value = "В яндекс маркете выбрать телефоны." +
            " Установить фильтр (checkbox) iOS (айфон)." +
            " Убедится что на всех страницах (если их несколько), присутствуют только айфоны. ")
    public void testPFYandexTelephonesCheckIOS() {
        chromeDriver.get("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?text=телефоны");
        PageFactoryMarketYandex pageFactoryYandex = PageFactory.initElements(chromeDriver, PageFactoryMarketYandex.class);
        pageFactoryYandex.setFilterCheckBoxBoxIOs();
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

}

