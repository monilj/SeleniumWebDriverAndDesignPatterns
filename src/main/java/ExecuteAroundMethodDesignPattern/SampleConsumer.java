package ExecuteAroundMethodDesignPattern;

import java.util.function.Consumer;

public class SampleConsumer {
    public static void main(String[] args) {
        test((d -> System.out.println(d)));
    }
    public static void test(Consumer<String> consumer){
        String s = "Udemy";
        consumer.accept(s);
    }
}
