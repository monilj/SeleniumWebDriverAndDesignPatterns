package TemplatePattern;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WEmbeddedFrame;

import java.sql.Time;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonShopping extends ShoppingTemplate {
    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css ="input[value='Go']")
    private WebElement searchBtn;

        @FindBy(css = "span.a-size-medium")
    private WebElement item;

    @FindBy(xpath = "//span[@id='priceblock_ourprice']")
    private WebElement price;

    public AmazonShopping(final WebDriver driver,String product)
    {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver,15);
        PageFactory.initElements(driver,this);
    }
    @Override
    public void launchSite() {
        this.driver.get("https://www.amazon.in");
    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();
    }

    @Override
    public void selectProduct() {
                wait.until((driver1 -> item.isDisplayed()));
                item.click();
       }

    @Override
    public void buy() {
        driver.getTitle();
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
