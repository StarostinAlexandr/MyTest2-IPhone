package practica;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings {

    @Test
    @Description(value = "В яндекс маркете выбрать телефоны")
    public void testPOMarketYandexTelephone() {
        int i = 1;
        int j = 1;
        String s = "";

        PageObjectMarketYandex pageObjectMarketYandex = new PageObjectMarketYandex(chromeDriver, "телефоны");
        pageObjectMarketYandex.setFilterCheckBoxBoxIOs();

   /*     System.out.println(pageObjectMarketYandex.getSearchWebItems().size());
        System.out.println(pageObjectMarketYandex.getCollectResults().size());
//        pageObjectMarketYandex.getCollectResults().stream().forEach(System.out::println);

        pageObjectMarketYandex.setFilterCheckBoxBoxIOs();
        System.out.println();
        pageObjectMarketYandex.clearCollectResult();
        System.out.println(pageObjectMarketYandex.getCollectResults().size());
        pageObjectMarketYandex.clearCollectResult();

        for(String s: pageObjectMarketYandex.getCollectResults()) {
            System.out.println(i + " " + s);
            i++;
        }*/
//        pageObjectMarketYandex.getCollectResults().stream().forEach(System.out::println);
//        System.out.println(pageObjectMarketYandex.isButtonForwardToNextPage());
//        System.out.println(pageObjectMarketYandex.getForwardToNextPage().getAttribute("data-bem"));
        do {
            for (String str : pageObjectMarketYandex.getCollectResults()) {
                System.out.println(i + " " + str);
                i++;
            }
            pageObjectMarketYandex.clearCollectResult();
            if (!pageObjectMarketYandex.isExistsButtonShowMorePages()) {
                break;
            }
            System.out.println("CLICK!!!!!!!!!!!!!!!!!!!!!!!!!!");
            j++;
            s = "&page=" + String.valueOf(j);
            System.out.println(pageObjectMarketYandex.getForwardToNextPage().getAttribute("href"));
            pageObjectMarketYandex.getForwardToNextPage().click();
            System.out.println(pageObjectMarketYandex.getForwardToNextPage().getAttribute("href"));
        }
        while (true);

//            pageObjectMarketYandex.getCollectResults().stream().forEach(System.out::println);

    }

    @Test
    @Description(value = "Установить фильтр (checkbox) iOS (айфон) ")
    public void testPOMarketYandexCheckIOs() {
        PageObjectMarketYandex pageObjectMarketYandex = new PageObjectMarketYandex(chromeDriver, "телефоны");
        pageObjectMarketYandex.setFilterCheckBoxBoxIOs();

        int i = 1;
//        pageObjectMarketYandex.getTitleFromWebItems();

        do {
            if (pageObjectMarketYandex.isExistsButtonShowMorePages()) {

//                pageObjectMarketYandex.clickButton();
//                pageObjectMarketYandex.getTitleFromWebItems();

            } else break;
        } while (true);
        Assertions.assertTrue(pageObjectMarketYandex.isTitleContainsIPhone());
//        pageObjectMarketYandex.checkTitle();
    }


}

