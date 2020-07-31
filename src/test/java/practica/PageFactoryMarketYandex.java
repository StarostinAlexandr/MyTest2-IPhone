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

    @FindAll(@FindBy(how = How.XPATH, using="//h2[@class=\"organic__title-wrapper typo typo_text_l typo_line_m\"]"))
    private List<WebElement> searchWebItems = new ArrayList<>();

    private List<String> collectResults = new ArrayList<>();

    public List<String> getCollectResults() {
        searchWebItems.stream().forEach(x->collectResults.add(x.getText()));
        return collectResults;
    }

}
