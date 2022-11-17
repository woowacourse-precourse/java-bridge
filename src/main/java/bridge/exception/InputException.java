package bridge.exception;

public class InputException {

    public void inputNullException(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] input is null");
        }
    }

}
