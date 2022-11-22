package bridge.exception;

public class IllegalArgumentError extends IllegalArgumentException {

    public IllegalArgumentError(String message) {
        super("[ERROR] " + message);
        System.out.println(super.getMessage());
    }
}
