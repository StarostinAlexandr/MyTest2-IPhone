package practica;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageObjectMarketYandex {
    //    private String selectorSearchItems="//h2[@class='organic__title-wrapper typo typo_text_l typo_line_m']";
//    private String selectorSearchItems = "//article";
//    private String selectorCssCheckBoxIOs = "[name='Платформа iOS'][type=checkbox]";
    private String selectorXpathCheckBoxIOs = "//span[text()='iOS']";
    private String selectorXpathArticleText = "//article//h3/a";
//    private String selectorXpathDivResultPages = "//div[contains(@data-bem,\"itemsPerPage\")]";
    private String selectorXpathButtonShowMorePages = "//button[text()='Показать ещё']";
//    private String selectorXpathForwardToNextPage = "//a[@aria-label='Следующая страница']";
//    private String selectorXpathForwardToNextPage = "//a[@class='button button_size_s button_theme_pseudo n-pager__button-next i-bem n-smart-link button_js_inited n-smart-link_js_inited']";
//                                                    a[@class="button button_size_s button_theme_pseudo n-pager__button-next i-bem n-smart-link button_js_inited n-smart-link_js_inited"]
//                                                            button button_size_m button_theme_pseudo i-bem button_js_inited

    private WebDriver driver;
    private List<WebElement> searchWebItems = new ArrayList<>();
    private List<String> collectResults = new ArrayList<>();
    private WebElement filterCheckBoxIOs;
    private WebElement buttonShowMorePages;

    public PageObjectMarketYandex(WebDriver driver, String search) {
        this.driver = driver;
        this.driver.get("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?text=" + search);
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

    public boolean isTitleContainsIPhone() {
        searchWebItems = driver.findElements(By.xpath(selectorXpathArticleText));
        System.out.println("getTitle 2 " + searchWebItems.size());
        searchWebItems.stream().forEach(x -> collectResults.add(x.getAttribute("title")));
        System.out.println("getTitle 3 " + collectResults.size());
        int i = 1;
        for (String str : collectResults) {
            System.out.println(i + " " + str);
            i++;
        }
        return collectResults.stream().anyMatch(x -> x.contains("iPhone"));

    }

}
