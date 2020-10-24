package ExecuteAroundMethodDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.applet.Main;

public class MainPage {
    public WebDriver driver;

    @FindBy(id = "a")
    private WebElement frameA;

    @FindBy(id = "b")
    private WebElement frameB;

    @FindBy(id = "c")
    private WebElement frameC;

    private FrameA frameObjectA;
    private FrameB frameObjectB;
    private FrameC frameObjectC;


    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.frameObjectA = PageFactory.initElements(driver,FrameA.class);
        this.frameObjectB = PageFactory.initElements(driver,FrameB.class);
        this.frameObjectC = PageFactory.initElements(driver,FrameC.class);
    }

    public void goToSite(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }
    public FrameA getFrameObjectA(){
        this.driver.switchTo().frame(frameA);
        return frameObjectA;
    }

    public FrameB getFrameObjectB(){
        this.driver.switchTo().frame(frameB);
        return frameObjectB;
    }


}
