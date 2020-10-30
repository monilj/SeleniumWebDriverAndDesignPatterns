package DecoratorDesignPattern;

import BaseTestPackage.BaseTest;
import DecoratorPattern.DashBoardPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashBoardTest extends BaseTest {
    private DashBoardPage dashBoardPage;

    @BeforeTest
    public void setDashBoardPage(){
        this.dashBoardPage = new DashBoardPage(driver);
    }
    @Test(dataProvider= "getData")
    public void roleTest(Consumer<DashBoardPage> role){
        this.dashBoardPage.goToSite();
        role.accept(this.dashBoardPage);
    }
    @DataProvider
    public Object[] getData(){
        return new Object[]{
        Decorators.guestPage,
        Decorators.superUserPage,
        Decorators.adminUserPage
        };
    }
}
