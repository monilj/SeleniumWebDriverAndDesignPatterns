package SingleResponsibilityPrinciple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBoxComponent extends AbstractComponent {

    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;


    public SearchBoxComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver, this);
    }

    public void enterAString(String input){
        this.searchBox.clear();
        this.searchBox.sendKeys(input);
    }

    @Override
    public boolean isDisplay() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        return this.searchBox.isDisplayed();
    }
}
