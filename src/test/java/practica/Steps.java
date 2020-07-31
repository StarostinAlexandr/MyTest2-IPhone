package practica;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class Steps {

    @Step("Шаг 1. Проверка что результатов больше трёх ")
    public static void checkYandexResultMoreThanThree(List<String> resultSearch, WebDriver driver){
        if(resultSearch.size() > 3){
            Assertions.assertTrue(true);
        }
        else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false
                    , "Список с результатом поиска имеет размер не более трёх элементов");
        }
    }

    @Step("Шаг 1. Проверка что результате список не должен быть больше нуля (негативный тест)")
    public static void checkYandexResultMoreThanZeroNegative(List<String> resultSearch, WebDriver driver){
        if(resultSearch.size() > 0){
            Assertions.assertFalse(true
                    , "Список с результатом поиска не должен быть больше нуля ");
            CustomUtils.getScreen(driver);
        }
        else {
            Assertions.assertFalse(false);
        }
    }

    @Step("Шаг 2. Проверка наличия имени: {name}")
    public static void checkContainsName(List<String> resultSearch, String name, WebDriver driver){
        if(resultSearch.stream().anyMatch(x -> x.contains(name))){
            Assertions.assertTrue(true);
        }
        else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false,"Не найдено: "+ name);
        }
    }

    @Step("Шаг 2. Проверка наличия имени: {name} (негативный тест)")
    public static void checkContainsNameNegative(List<String> resultSearch, String name, WebDriver driver){
        if(resultSearch.stream().anyMatch(x -> x.contains(name))){
            Assertions.assertFalse(true, "Не должен быть найден: "+ name);
            CustomUtils.getScreen(driver);
        }
        else {
            Assertions.assertFalse(false);
        }
    }





}
