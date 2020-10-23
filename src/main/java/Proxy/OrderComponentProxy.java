package Proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent  {
    private static final List<String> EXCLUDED = Arrays.asList(
      "PROD", "STAGING"
    );
    private OrderComponent orderComponent;

    public OrderComponentProxy(final WebDriver driver){
        String currentEnv = System.getProperty("env"); //return DEV, QA, PROD
        if(!EXCLUDED.contains(currentEnv)) //for PROD it will return True otherwise false
            this.orderComponent = new OrderComponentReal(driver);

    }

    @Override
    public String placeOrder() {
        if(Objects.nonNull(this.orderComponent))
            {
                return this.orderComponent.placeOrder();
            }
        else{
            return "Skipped";
        }
    }
}
