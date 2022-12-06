package bridge;

@FunctionalInterface
public interface TestInterface<T> {
    void print();

    default void printDefault() {
        System.out.println("Hello, Default!");
    }

    static void printStatic() {
        System.out.println("Hello, Static!");
    }
}
