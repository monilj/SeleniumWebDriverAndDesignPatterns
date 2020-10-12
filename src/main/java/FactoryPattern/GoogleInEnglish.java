package FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleInEnglish extends GooglePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id="searchBox")
    private WebElement searchBox;

    @FindBy(name="btnk")
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
        searchButton.click();

    }

    @Override
    public int getResultsCount() {
        this.wait.until(driver -> this.results.size() >1);
        return this.results.size();
    }
}
