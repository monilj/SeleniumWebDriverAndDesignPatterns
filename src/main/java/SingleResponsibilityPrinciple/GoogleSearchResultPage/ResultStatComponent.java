package SingleResponsibilityPrinciple.GoogleSearchResultPage;

import SingleResponsibilityPrinciple.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStatComponent extends AbstractComponent {

    @FindBy(id="result-stats")
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
