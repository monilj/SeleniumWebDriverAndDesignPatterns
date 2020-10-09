package SingleResponsibilityPrinciple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchSuggestionsComponent extends AbstractComponent {
    @FindBy(css = "li.sbct")
    private List<WebElement> googleSuggestions;

    public SearchSuggestionsComponent(final WebDriver driver) {
        super(driver);
    }

    public void clickOnSuggestionByIndex(int index) {
        this.googleSuggestions.get(index - 1).click();
    }

    @Override
    public boolean isDisplay() {
        return this.wait.until((driver -> this.googleSuggestions.size() > 5));
    }
}
