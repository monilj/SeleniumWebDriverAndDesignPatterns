package SingleResponsibilityPrinciple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriverWait wait;

    public AbstractComponent(final WebDriver driver){
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver,this);
    }
    public abstract boolean isDisplay();
}
