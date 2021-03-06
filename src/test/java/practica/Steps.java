package practica;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Map;

public class Steps {

    @Step("Шаг 1. Позитивный. Проверка выбора телефонов ")
    public static void checkMarketYandexPhonesSelected(boolean isExistsPhoneText, WebDriver driver) {
        if (isExistsPhoneText) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Телефоны не выбраны");
        }
    }

    @Step("Шаг 2. Проверка установки фильтра айфоны (iOs)")
    public static void checkSetFilterIOS(WebElement filter, WebDriver driver) {
        System.out.println(filter.isSelected());
        if (filter.isSelected()) {
            Assertions.assertTrue(true);
        } else {
            Assertions.fail("Фильтр iOS не установлен");
            CustomUtils.getScreen(driver);
        }

    }


    @Step("Шаг 3. Проверка наличия имени: {name}")
    public static void checkContainsName(List<String> resultSearch, String name, WebDriver driver) {
        if (resultSearch.stream().peek(System.out::println).allMatch(x -> x.toLowerCase().contains(name))) {
            Assertions.assertTrue(true);
            System.out.println();
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Не найдено: " + name);
        }
    }

    @Step("Шаг 3. Негативный. Проверка наличия имени: {name} ")
    public static void checkContainsNameNegative(List<String> resultSearch, String name, WebDriver driver) {
        if (resultSearch.stream().peek(System.out::println).allMatch(x -> x.toLowerCase().contains(name))) {
            Assertions.fail("Если не выбраны " + name + " nо Все телефоны не могут быть " + name);
            CustomUtils.getScreen(driver);
        } else {
            Assertions.assertFalse(false);
        }
    }


}
