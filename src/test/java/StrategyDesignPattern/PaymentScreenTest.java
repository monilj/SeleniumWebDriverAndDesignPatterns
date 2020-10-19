package StrategyDesignPattern;

import BaseTestPackage.BaseTest;
import StrategyPattern.CreditCard;
import StrategyPattern.NetBanking;
import StrategyPattern.PaymentOption;
import StrategyPattern.PaymentScreen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;
    @BeforeTest
    public void setPaymentScreen(){
        this.paymentScreen = new PaymentScreen(this.driver);
    }
    @Test(dataProvider = "getData")
    public void paymentTest(PaymentOption paymentOption, Map<String,String> paymentDetails)
    {
        this.paymentScreen.goToSite();
        this.paymentScreen.getUserInformation().enterDetails("John","Smith","sss@gmail.com");
        this.paymentScreen.setPaymentOption(paymentOption);
        this.paymentScreen.pay(paymentDetails);
        String orderNumber= this.paymentScreen.getOrder().placeOrder();
        System.out.println(orderNumber);
    }

    @DataProvider
    public Object[][] getData(){
        Map<String,String> cc = new HashMap<>();
        cc.put("cc","12342232");
        cc.put("year","2024");
        cc.put("cvv","124");

        Map<String,String> nb = new HashMap<>();
        nb.put("bank","Random");
        nb.put("account","myac224");
        nb.put("pin","1221");
        return new Object[][]{
                {new CreditCard(),cc},
                {new NetBanking(),nb}
        };
    }
}
