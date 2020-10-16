package FactoryDesignPattern;

import BaseTestPackage.BaseTest;
import FactoryPattern.GoogleFactory;
import FactoryPattern.GooglePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String userInput ){
        this.googlePage = GoogleFactory.get(language,this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(userInput);
        int resultsCount= this.googlePage.getResultsCount();
        System.out.println(resultsCount);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"ENG","Selenium"},
                {"FR","Docker"},
                {"SA","TestNg"},
                {"ES","Extent Reporting"}


        };
    }
}
