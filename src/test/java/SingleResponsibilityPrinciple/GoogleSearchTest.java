package SingleResponsibilityPrinciple;

import BaseTestPackage.BaseTest;
import SingleResponsibilityPrinciple.GoogleSearchResultPage.GoogleResultPage;
import SingleResponsibilityPrinciple.googleMainPage.GoogleMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {
    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setUpPage(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getData")
    public void searchTestWorkFlow(String userInput , int index){

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
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"Selenium WebDriver", 3},
                {"Docker", 2 }
        };
    }
}
