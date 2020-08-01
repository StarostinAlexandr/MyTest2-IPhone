package practica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class PageFactoryMarketYandex {

    @FindBy(how = How.XPATH, using="//span[text()='телефоны']")
    WebElement textPhones;

    @FindBy(how = How.XPATH, using="//input[@name='Платформа iOS'][@type='checkbox']")
    WebElement checkboxSetIOS;

    @FindBy(how = How.XPATH, using="//span[text()='iOS']")
    WebElement buttonSetIOS;

    @FindBy(how = How.XPATH, using="//button[text()='Показать ещё']")
    WebElement buttonShowMorePages;

    @FindAll(@FindBy(how = How.XPATH, using="//article//h3/a"))
    private List<WebElement> searchWebItems = new ArrayList<>();

    WebElement filterCheckBoxIOs;

    private List<String> collectResults = new ArrayList<>();


    public List<String> getCollectResults() {
        searchWebItems.forEach(x->collectResults.add(x.getAttribute("title")));
        return collectResults;
    }

    public WebElement getCheckboxSetIOS() {
        return checkboxSetIOS;
    }

    public boolean isExistsPhoneTextWhenPhonesSelected() {
        try {
            textPhones.isDisplayed();
            System.out.println("try find text phones");

        } catch (Exception e) {
            System.out.println("catch");
            textPhones = null;
        }
        System.out.println("return " + (textPhones != null));
        return textPhones != null;
    }

    public void setFilterCheckBoxBoxIOs() {
        if (!checkboxSetIOS.isSelected()) {
            buttonSetIOS.click();
        }
    }
    public boolean isExistsButtonShowMorePages() {
        try {
            buttonShowMorePages.isDisplayed();
            System.out.println("try");

        } catch (Exception e) {
            System.out.println("catch");
            buttonShowMorePages = null;
        }
        System.out.println("return " + (buttonShowMorePages != null));
        return buttonShowMorePages != null;
    }

}
