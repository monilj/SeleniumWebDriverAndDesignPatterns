package TemplatePattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class eBayShopping extends ShoppingTemplate{

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    @FindBy(css = "div.s-item__info a")
    private WebElement item;

    @FindBy(css = ".s-item__price")
    private WebElement price;

    public eBayShopping(final WebDriver driver,String product)
    {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver,15);
        PageFactory.initElements(driver,this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://in.ebay.com/");

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
