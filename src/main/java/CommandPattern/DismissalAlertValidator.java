package CommandPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {
    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        boolean resultBeforeClosing = this.dismissalAlert.isDisplayed(); //should be true
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean resultAfterClosing=  this.dismissalAlert.isDisplayed(); //should be false
        return resultBeforeClosing && (!resultAfterClosing);
    }
}
