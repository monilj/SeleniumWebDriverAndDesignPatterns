package FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

 class GoogleInFrench extends GoogleInEnglish {

    @FindBy(linkText = "Français")
    private WebElement frenchLink;

    public GoogleInFrench(final WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.fr/");
        this.frenchLink.click();
    }
}
