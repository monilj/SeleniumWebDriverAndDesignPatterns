package DecoratorPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashBoardPage {

    public WebDriver driver;

    @FindBy(id = "role")
    private WebElement role;

    @FindBy(css = "div.guest")
    private List<WebElement> guestComponents;

    @FindBy(css = "div.superuser")
    private List<WebElement> superuserComponents;

    @FindBy(css = "div.admin")
    private List<WebElement> adminComponents;

    public DashBoardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToSite(){
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectRole(String role){
        Select select = new Select(this.role);
        select.selectByValue(role);
    }

    public List<WebElement> getGuestComponents() {
        return guestComponents;
    }

    public List<WebElement> getSuperuserComponents() {
        return superuserComponents;
    }

    public List<WebElement> getAdminComponents() {
        return adminComponents;
    }
}
