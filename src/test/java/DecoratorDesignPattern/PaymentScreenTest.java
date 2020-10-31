package DecoratorDesignPattern;

import BaseTestPackage.BaseTest;
import DecoratorPattern.PaymentScreenPage;
import Proxy.PaymentScreen;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static DecoratorDesignPattern.PaymentDecorators.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreenPage paymentScreenPage;

    @BeforeTest
    public void setPaymentScreenPage(){
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer){
        paymentScreenPage.goTo();
        consumer.accept(paymentScreenPage);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                validCC.andThen(buy).andThen(successPurchase),
                freeCoupon.andThen(buy).andThen(successPurchase),
                discountedCoupon.andThen(validCC).andThen(buy).andThen(successPurchase),
                inValidCC.andThen(buy).andThen(failedPurchase),
                inValidCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
                buy.andThen(failedPurchase)
        };
    }
}