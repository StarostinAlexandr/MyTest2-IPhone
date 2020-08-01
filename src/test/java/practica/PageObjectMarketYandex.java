package practica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;

import java.util.ArrayList;
import java.util.List;

public class PageObjectMarketYandex {

    private String selectorXpathTextCheckBoxIOs = "//span[text()='iOS']";
    private String selectorXpathCheckBoxIOs = "//input[@name='Платформа iOS'][@type='checkbox']";
    private String selectorXpathArticleText = "//article//h3/a";
    private String selectorXpathPhonesText = "//span[text()='телефоны']";
    private String selectorXpathButtonShowMorePages = "//button[text()='Показать ещё']";

    private WebDriver driver;
    private List<WebElement> searchWebItems = new ArrayList<>();
    private List<String> collectResults = new ArrayList<>();
    private WebElement filterCheckBoxIOs;
    private WebElement filterTextCheckBoxIOs;
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

    public WebElement getFilterCheckBoxIOs() {
        return filterCheckBoxIOs = driver.findElement(By.xpath(selectorXpathCheckBoxIOs));
    }

    public void setFilterCheckBoxBoxIOs() {
        filterTextCheckBoxIOs = driver.findElement(By.xpath(selectorXpathTextCheckBoxIOs));
        filterCheckBoxIOs = driver.findElement(By.xpath(selectorXpathCheckBoxIOs));
        if (!filterCheckBoxIOs.isSelected()) {
            filterTextCheckBoxIOs.click();
        }
    }

    public boolean isExistsPhoneTextWhenPhonesSelected() {
        try {
            textPhones = driver.findElement(By.xpath(selectorXpathPhonesText));
        } catch (Exception e) {
            textPhones = null;
        }
        return textPhones != null;
    }

    public boolean isExistsButtonShowMorePages() {
        try {
            buttonShowMorePages = driver.findElement(By.xpath(selectorXpathButtonShowMorePages));
        } catch (Exception e) {
            buttonShowMorePages = null;
        }
        return buttonShowMorePages != null;
    }

    public void collectResultByTitle() {
        searchWebItems = driver.findElements(By.xpath(selectorXpathArticleText));
        searchWebItems.forEach(x -> collectResults.add(x.getAttribute("title")));
    }

}
