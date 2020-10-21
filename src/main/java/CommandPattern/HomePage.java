package CommandPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    //buttons
    @FindBy(css = ".tst1.btn.btn-info")
    private WebElement infoButton;

    @FindBy(css = ".tst1.btn.btn-warning")
    private WebElement warningButton;

    @FindBy(css = ".tst1.btn.btn-success")
    private WebElement successButton;

    @FindBy(css = ".tst1.btn.btn-danger")
    private WebElement dangerButton;

    //notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //dismissal Alerts
    @FindBy(css = "div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "div.alert-warning")
    private WebElement dismissWarnAlert;



    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToSite() {
        this.driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
    }


}
