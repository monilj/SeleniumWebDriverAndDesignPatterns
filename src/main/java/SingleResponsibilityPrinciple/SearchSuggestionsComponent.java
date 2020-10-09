package SingleResponsibilityPrinciple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchSuggestionsComponent extends AbstractComponent {

    private WebDriverWait wait;

    @FindBy(css = "li.sbct")
    private List<WebElement> googleSuggestions;

    public SearchSuggestionsComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickOnSuggestionByIndex(int index) {
        this.googleSuggestions.get(index - 1).click();
    }

    @Override
    public boolean isDisplay() {
        this.wait.until((driver -> this.googleSuggestions.size() > 5));
        return false;
    }
}
