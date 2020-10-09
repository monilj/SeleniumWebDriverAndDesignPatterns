package SingleResponsibilityPrinciple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStatComponent extends AbstractComponent {

    @FindBy(id="resultStats")
    private WebElement resultStat;
    public ResultStatComponent(WebDriver driver) {
        super(driver);
    }

    public String getResultStats(){
        return this.resultStat.getText();
    }
    @Override
    public boolean isDisplay() {
        return false;
    }
}
