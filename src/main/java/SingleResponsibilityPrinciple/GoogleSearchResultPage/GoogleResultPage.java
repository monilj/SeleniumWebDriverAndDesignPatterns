package SingleResponsibilityPrinciple.GoogleSearchResultPage;

import SingleResponsibilityPrinciple.common.SearchBoxComponent;
import SingleResponsibilityPrinciple.common.SearchSuggestionsComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {

    private SearchBoxComponent searchBoxComponent;
    private SearchSuggestionsComponent searchSuggestionsComponent;
    private SearchPageMenuComponent searchPageMenuComponent;
    private ResultStatComponent resultStatComponent;

    public GoogleResultPage(final WebDriver driver){
        this.searchBoxComponent = PageFactory.initElements(driver, SearchBoxComponent.class);
        this.searchSuggestionsComponent = PageFactory.initElements(driver, SearchSuggestionsComponent.class);
        this.searchPageMenuComponent = PageFactory.initElements(driver, SearchPageMenuComponent.class);
        this.resultStatComponent = PageFactory.initElements(driver, ResultStatComponent.class);
    }

    public SearchBoxComponent getSearchBoxComponent() {
        return searchBoxComponent;
    }

    public SearchSuggestionsComponent getSearchSuggestionsComponent() {
        return searchSuggestionsComponent;
    }

    public SearchPageMenuComponent getSearchPageMenuComponent() {
        return searchPageMenuComponent;
    }

    public ResultStatComponent getResultStatComponent() {
        return resultStatComponent;
    }
}
