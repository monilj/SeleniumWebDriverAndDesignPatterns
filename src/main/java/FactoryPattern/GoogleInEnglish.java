package FactoryPattern;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

 class GoogleInEnglish extends GooglePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(name="btnK")
    private WebElement searchButton;

    @FindBy(css = "div.rc")
    private List<WebElement> results;

    public GoogleInEnglish(final WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    @Override
    public void launchSite() {
        driver.get("http://www.google.com");
    }

    @Override
    public void search(String userInput) {
        searchBox.sendKeys(userInput);
        searchBox.sendKeys(Keys.TAB);
        searchButton.submit();
    }

    @Override
    public int getResultsCount() {
        this.wait.until(driver -> this.results.size() >1);
        return this.results.size();
    }
}
