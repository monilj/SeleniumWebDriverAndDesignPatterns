package TemplatePattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WEmbeddedFrame;

import java.sql.Time;

public class AmazonShopping extends ShoppingTemplate {
    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css ="input.nav-input")
    private WebElement searchBtn;

    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    @FindBy(id = "priceblock_dealprice")
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
        wait.until((driver1 -> price.isDisplayed()));
        System.out.println(this.price.getText());
    }
}
