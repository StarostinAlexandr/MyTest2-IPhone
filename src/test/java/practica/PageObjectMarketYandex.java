package practica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PageObjectMarketYandex {
    //    private String selectorSearchItems="//h2[@class='organic__title-wrapper typo typo_text_l typo_line_m']";
//    private String selectorSearchItems = "//article";
//    private String selectorCssCheckBoxIOs = "[name='Платформа iOS'][type=checkbox]";
    //    private String selectorXpathDivResultPages = "//div[contains(@data-bem,\"itemsPerPage\")]";

    private String selectorXpathCheckBoxIOs = "//span[text()='iOS']";
    private String selectorXpathArticleText = "//article//h3/a";
    private String selectorXpathPhonesText = "//span[text()='телефоны']";
    private String selectorXpathButtonShowMorePages = "//button[text()='Показать ещё']";

    private WebDriver driver;
    private List<WebElement> searchWebItems = new ArrayList<>();
    private List<String> collectResults = new ArrayList<>();
    private WebElement filterCheckBoxIOs;
    private WebElement buttonShowMorePages;
    private WebElement textPhones;

    public PageObjectMarketYandex(WebDriver driver, String search) {
        this.driver = driver;
        this.driver.get("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?text=" + search);
    }

    public List<String> getCollectResults() {
        return collectResults;
    }

    public WebElement getButtonShowMorePages() {
        return buttonShowMorePages;
    }

    public void setFilterCheckBoxBoxIOs() {
        filterCheckBoxIOs = driver.findElement(By.xpath(selectorXpathCheckBoxIOs));
        if (!filterCheckBoxIOs.isSelected()) {
            filterCheckBoxIOs.click();
        }
    }

    public boolean isExistsPhoneTextWhenPhonesSelected() {
        try {
            textPhones = driver.findElement(By.xpath(selectorXpathPhonesText));
            System.out.println("try find text phones");

        } catch (Exception e) {
            System.out.println("catch");
            textPhones = null;
        }
        System.out.println("return " + (textPhones != null));
        return textPhones != null;
    }

    public boolean isExistsButtonShowMorePages() {
        try {
            buttonShowMorePages = driver.findElement(By.xpath(selectorXpathButtonShowMorePages));
            System.out.println("try");

        } catch (Exception e) {
            System.out.println("catch");
            buttonShowMorePages = null;
        }
        System.out.println("return " + (buttonShowMorePages != null));
        return buttonShowMorePages != null;
    }

    public void collectResultByTitle() {
        searchWebItems = driver.findElements(By.xpath(selectorXpathArticleText));
        System.out.println("getTitle 2 " + searchWebItems.size());
        searchWebItems.forEach(x -> collectResults.add(x.getAttribute("title")));
        System.out.println("getTitle 3 " + collectResults.size());
        int i = 1;
        for (String str : collectResults) {
            System.out.println(i + " " + str);
            i++;
        }
//        return collectResults.stream().anyMatch(x -> x.contains("iPhone"));

    }

}
