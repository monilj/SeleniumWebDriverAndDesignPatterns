package StrategyDesignPattern;

import BaseTestPackage.BaseTest;
import StrategyPattern.PaymentOption;
import StrategyPattern.PaymentScreen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;
    @BeforeTest
    public void setPaymentScreen(){
        this.paymentScreen = new PaymentScreen(this.driver);
    }
    @Test
    public void paymentTest(PaymentOption paymentOption, Map<String,String> paymentDetails)
    {
        this.paymentScreen.goToSite();
        this.paymentScreen.getUserInformation().enterDetails("John","Smith","sss@gmail.com");
        this.paymentScreen.setPaymentOption(paymentOption);
        this.paymentScreen.pay(paymentDetails);
        String orderNumber= this.paymentScreen.getOrder().placeOrder();
        System.out.println(orderNumber);
    }
}
