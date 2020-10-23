package TemplatePattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchPage {
    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css ="input[value='Go']")
    private WebElement searchBtn;

    public AmazonSearchPage(final WebDriver driver){
        this.driver = driver;

    }

    public void goTo() {
        this.driver.get("https://www.amazon.in");
    }


    public void search(String product) {
        this.searchBox.sendKeys(product);
        this.searchBtn.click();
    }

}
