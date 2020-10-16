package FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleInSpanish extends GoogleInEnglish {

    @FindBy(linkText = "español")
    private WebElement spanishLink;

    public GoogleInSpanish(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.es/");
        this.spanishLink.click();
    }
}
