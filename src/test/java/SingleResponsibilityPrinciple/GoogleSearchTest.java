package SingleResponsibilityPrinciple;

import BaseTestPackage.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest extends BaseTest {
    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setUpPage(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test
    public void searchTestWorkFlow(){
        String userInput = "Selenium WebDriver";
        int index = 3;

        googleMainPage.goToGoogleHomePage();
        Assert.assertTrue(googleMainPage.getSearchBox().isDisplay());

        googleMainPage.getSearchBox().enterAString(userInput);
        Assert.assertTrue(googleMainPage.getSearchSuggestions().isDisplay());

        googleMainPage.getSearchSuggestions().clickOnSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getSearchPageMenuComponent().isDisplay());

        googleResultPage.getSearchBoxComponent().enterAString(userInput);
        Assert.assertTrue(googleResultPage.getSearchSuggestionsComponent().isDisplay());

        googleResultPage.getSearchSuggestionsComponent().clickOnSuggestionByIndex(index);

        googleResultPage.getSearchPageMenuComponent().clickOnNews();

        System.out.println(googleResultPage.getResultStatComponent().getResultStats());

    }
}
