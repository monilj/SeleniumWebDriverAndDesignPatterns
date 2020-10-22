package TemplateDesignPattern;

import BaseTestPackage.BaseTest;
import TemplatePattern.AmazonShopping;
import TemplatePattern.ShoppingTemplate;
import TemplatePattern.eBayShopping;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate){
        shoppingTemplate.shop();

    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                new AmazonShopping(driver,"samsung"),
                new eBayShopping(driver,"samsung")
        };
    }
}
