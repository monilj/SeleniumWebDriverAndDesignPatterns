package ExecuteAroundMethodDesignPattern;

import BaseTestPackage.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    private MainPage mainPage;

    @BeforeTest
    public void setMainPage(){
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest(){
        this.mainPage.goToSite();
        this.mainPage.getFrameObjectA().setFirstName("fn1");
        this.mainPage.getFrameObjectB().setFirstName("fn2");

    }
}

