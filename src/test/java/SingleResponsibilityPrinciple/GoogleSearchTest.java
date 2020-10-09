package SingleResponsibilityPrinciple;

import BaseTestPackage.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
        googleMainPage.goToGoogleHomePage();
        Assert.assertTrue(googleMainPage.getSearchBox().isDisplay());
    }
}
