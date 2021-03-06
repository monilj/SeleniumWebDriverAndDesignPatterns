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

    @FindBy(css = ".tst2.btn.btn-warning")
    private WebElement warningButton;

    @FindBy(css = ".tst3.btn.btn-success")
    private WebElement successButton;

    @FindBy(css = ".tst4.btn.btn-danger")
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
    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-info')]//button[@class='close']")
    private WebElement dismissInfoAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-success')]//button[@class='close']")
    private WebElement dismissSuccessAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-danger')]//button[@class='close']")
    private WebElement dismissDangerAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-warning')]//button[@class='close']")
    private WebElement dismissWarnAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToSite() {
        this.driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
    }
    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
                //notification Validation
                new NotificationValidator(infoButton, infoAlert),
                new NotificationValidator(successButton, successAlert),
                new NotificationValidator(warningButton, warnAlert),
                new NotificationValidator(dangerButton, dangerAlert),

                //Dismiss Alert
                new DismissalAlertValidator(dismissInfoAlert),
                new DismissalAlertValidator(dismissSuccessAlert),
                new DismissalAlertValidator(dismissWarnAlert),
                new DismissalAlertValidator(dismissDangerAlert)
        );
    }


}
