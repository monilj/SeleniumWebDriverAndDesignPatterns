package CommandPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToSite() {
        this.driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
    }


}
