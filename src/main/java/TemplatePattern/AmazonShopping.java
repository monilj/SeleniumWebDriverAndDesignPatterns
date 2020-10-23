package TemplatePattern;

import TemplatePattern.pages.AmazonProductDescriptionPage;
import TemplatePattern.pages.AmazonResultPage;
import TemplatePattern.pages.AmazonSearchPage;
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
    private String product;

    private AmazonSearchPage amazonSearchPage;
    private AmazonResultPage amazonResultPage;
    private AmazonProductDescriptionPage amazonProductDescriptionPage;


    public AmazonShopping(final WebDriver driver,String product)
    {
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver,AmazonSearchPage.class);
        this.amazonResultPage = PageFactory.initElements(driver,AmazonResultPage.class);
        this.amazonProductDescriptionPage = PageFactory.initElements(driver,AmazonProductDescriptionPage.class);
    }
    @Override
    public void launchSite() {
        this.amazonSearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.search(this.product);

    }

    @Override
    public void selectProduct() {
        this.amazonResultPage.selectProduct();
       }

    @Override
    public void buy() {
        this.amazonProductDescriptionPage.buy();
    }
}
