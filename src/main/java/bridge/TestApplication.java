package bridge;

public class TestApplication {
    public static void main(String[] args) {
        TestInterface<String> test = () -> System.out.println("Hello, FunctionalInterface!");

        test.print();
        test.printDefault();
        TestInterface.printStatic();
    }
}
