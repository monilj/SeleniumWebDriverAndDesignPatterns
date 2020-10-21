package CommandPattern;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DismissalAlertValidator extends ElementValidator {
    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        System.out.println("Inside alert");
//        boolean resultBeforeClosing = this.dismissalAlert.isDisplayed(); //should be true
        this.dismissalAlert.click();
        boolean resultAfterClosing=  this.dismissalAlert.isDisplayed(); //should be false
//        return resultBeforeClosing && (!resultAfterClosing);
        return resultAfterClosing;
    }
}
