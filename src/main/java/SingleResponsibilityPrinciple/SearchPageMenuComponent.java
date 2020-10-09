package SingleResponsibilityPrinciple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageMenuComponent extends AbstractComponent {
    @FindBy(id = "hdtb")
    private WebElement searchPageMenu;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(linkText = "News")
    private WebElement news;

    public SearchPageMenuComponent(WebDriver driver) {
        super(driver);
    }

    public void clickOnNews() {
        news.click();
    }

    public void clickOnImages() {
        images.click();
    }

    @Override
    public boolean isDisplay() {
        return this.wait.until((driver -> this.searchPageMenu.isDisplayed()));
    }
}
