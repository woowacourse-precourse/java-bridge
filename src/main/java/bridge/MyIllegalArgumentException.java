package bridge;

public class MyIllegalArgumentException extends IllegalArgumentException {
    MyIllegalArgumentException(String message) {
        System.out.println(message);
    }
}
