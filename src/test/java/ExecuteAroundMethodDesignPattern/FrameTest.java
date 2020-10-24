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
       this.mainPage.onFrameA(a ->
       {
           a.setFirstName("fn1");
           a.setLastName("ln1");
           a.setAddress("Nigdi");
           a.setMessage("I am awesome");
       });
        this.mainPage.onFrameB(b ->
        {
            b.setFirstName("fn2");
            b.setLastName("ln2");
            b.setAddress("Akurdi");
            b.setMessage("I am good");
        });
        this.mainPage.onFrameC(c ->
        {
            c.setFirstName("fn1");
            c.setLastName("ln1");
            c.setAddress("Nigdi");
            c.setMessage("I am awesome");
        });
    }
}

