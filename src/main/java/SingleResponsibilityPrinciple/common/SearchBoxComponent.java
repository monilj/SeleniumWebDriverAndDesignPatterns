package SingleResponsibilityPrinciple.common;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchBoxComponent extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchBoxComponent(final WebDriver driver) {
        super(driver);
    }

    public void enterAString(String input) {
        this.searchBox.clear();
        Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
        this.searchBox.sendKeys(input);
    }

    @Override
    public boolean isDisplay() {
        return this.wait.until((driver -> this.searchBox.isDisplayed()));
    }
}
