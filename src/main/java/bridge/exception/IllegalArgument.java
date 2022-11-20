package bridge.exception;

public class IllegalArgument {

    public static boolean isNotNumber(String numberInput) {
        if (numberInput.matches("[0-9]+")) {
            return false;
        }
        return true;
    }
}
