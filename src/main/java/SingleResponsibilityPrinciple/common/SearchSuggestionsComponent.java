package SingleResponsibilityPrinciple.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
