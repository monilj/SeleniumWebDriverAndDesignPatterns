package FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleInArabic extends GoogleInEnglish {

    @FindBy(css = "a[dir='rtl']")
    private WebElement arabicLink;

    @FindBy(css = "span.hOoLGe")
    private WebElement keyboardButton;

    @FindBy(id = "kbd")
    private WebElement keyBoardPanel;

    public GoogleInArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa");
        this.arabicLink.click();
    }

    @Override
    public void search(String userInput) {
        this.wait.until((driver -> this.keyboardButton.isDisplayed()));
        this.keyboardButton.click();
        this.wait.until((driver -> this.keyBoardPanel.isDisplayed()));
        super.search(userInput);
    }
}
