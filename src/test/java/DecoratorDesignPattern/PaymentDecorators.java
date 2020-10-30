package DecoratorDesignPattern;

import DecoratorPattern.PaymentScreenPage;
import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentDecorators {
    //actions or Test Cases
    public static final Consumer<PaymentScreenPage> freeCoupon = (p) -> p.applyPromoCode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage> discountedCoupon = (p) -> p.applyPromoCode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage> validCC = (p) -> p.enterCC("4111111111111111","2023","123");
    public static final Consumer<PaymentScreenPage> inValidCC = (p) -> p.enterCC("4111111111111112","2023","123");
    public static final Consumer<PaymentScreenPage> buy = (p) -> p.buyProduct();

//    validations

    public static final Consumer<PaymentScreenPage> successPurchase = (p) -> Assert.assertEquals(p.getStatus(),"PASS");
    public static final Consumer<PaymentScreenPage> failedPurchase = (p) -> Assert.assertEquals(p.getStatus(),"FAIL");
}
