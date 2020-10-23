package TemplatePattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class AmazonProductDescriptionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[@id='priceblock_ourprice']")
    private WebElement price;

    public AmazonProductDescriptionPage(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void buy() {
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                wait.until((driver1 -> price.isDisplayed()));
                System.out.println(this.price.getText());
            }
        }
    }
}
