package DecoratorDesignPattern;

import DecoratorPattern.DashBoardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements){
        elements.forEach(element ->Assert.assertTrue(element.isDisplayed())); //element.isDisplayed should return true
    }
    private static void shouldNotDisplay(List<WebElement> elements){
        elements.forEach(element ->Assert.assertFalse(element.isDisplayed())); //element.isDisplayed should return true
    }

//    ingredients
    private static final Consumer<DashBoardPage> adminComponentPresent = (dashBoardPage) -> shouldDisplay(dashBoardPage.getAdminComponents());
    private static final Consumer<DashBoardPage> adminComponentNotPresent = (dashBoardPage) -> shouldNotDisplay(dashBoardPage.getAdminComponents());
    private static final Consumer<DashBoardPage> superUserComponentPresent = (dashBoardPage) -> shouldDisplay(dashBoardPage.getSuperuserComponents());
    private static final Consumer<DashBoardPage> superUserComponentNotPresent = (dashBoardPage) -> shouldNotDisplay(dashBoardPage.getSuperuserComponents());
    private static final Consumer<DashBoardPage> guestComponentPresent = (dashBoardPage) -> shouldDisplay(dashBoardPage.getGuestComponents());
    private static final Consumer<DashBoardPage> guestComponentNotPresent = (dashBoardPage) -> shouldNotDisplay(dashBoardPage.getGuestComponents());

//    role selection
    private static final Consumer<DashBoardPage> adminSelection = (dashBoardPage) -> dashBoardPage.selectRole("admin");
    private static final Consumer<DashBoardPage> superUserSelection = (dashBoardPage) -> dashBoardPage.selectRole("superuser");
    private static final Consumer<DashBoardPage> guestSelection = (dashBoardPage) -> dashBoardPage.selectRole("guest");

//    user role pages
    //Guest Role
    public static final Consumer<DashBoardPage> guestPage = guestSelection.andThen(guestComponentPresent)
            .andThen(superUserComponentNotPresent).andThen(adminComponentNotPresent);

//    SuperUser Role
    public static final Consumer<DashBoardPage> superUserPage = superUserSelection.andThen(guestComponentPresent)
            .andThen(superUserComponentPresent).andThen(adminComponentNotPresent);
//    Admin Role
    public static final Consumer<DashBoardPage> adminUserPage = adminSelection.andThen(guestComponentPresent)
            .andThen(superUserComponentPresent).andThen(adminComponentPresent);

}
