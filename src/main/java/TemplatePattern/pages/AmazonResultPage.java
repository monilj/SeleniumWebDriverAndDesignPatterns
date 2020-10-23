package TemplatePattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    public AmazonResultPage(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver,this);
    }


    public void selectProduct() {
        wait.until((driver1 -> item.isDisplayed()));
        item.click();
    }


}
