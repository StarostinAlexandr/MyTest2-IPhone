package practica;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings {

    @Test
    @Description(value = "В яндекс маркете выбрать телефоны." +
            " Установить фильтр (checkbox) iOS (айфон)." +
            " Убедится что на всех страницах (если их несколько), присутствуют только айфоны. ")
    public void testPOMarketYandexTelephonesCheckIPhone() {
        PageObjectMarketYandex pageObjectMarketYandex = new PageObjectMarketYandex(chromeDriver, "телефоны");
        pageObjectMarketYandex.setFilterCheckBoxBoxIOs();

        while (pageObjectMarketYandex.isExistsButtonShowMorePages()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pageObjectMarketYandex.getButtonShowMorePages().click();
        }

        Assertions.assertTrue(pageObjectMarketYandex.isTitleContainsIPhone());
    }
}

