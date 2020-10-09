package SingleResponsibilityPrinciple.googleMainPage;

import SingleResponsibilityPrinciple.common.SearchBoxComponent;
import SingleResponsibilityPrinciple.common.SearchSuggestionsComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
    private WebDriver driver;
    private SearchBoxComponent searchBox;
    private SearchSuggestionsComponent searchSuggestions;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        this.searchBox = PageFactory.initElements(driver, SearchBoxComponent.class);
        this.searchSuggestions = PageFactory.initElements(driver, SearchSuggestionsComponent.class);
    }

    public void goToGoogleHomePage(){
        this.driver.get("https://www.google.com");
    }

    public SearchBoxComponent getSearchBox() {
        return searchBox;
    }

    public SearchSuggestionsComponent getSearchSuggestions() {
        return searchSuggestions;
    }
}

