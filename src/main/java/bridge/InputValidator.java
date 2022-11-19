package bridge;

public class InputValidator {
    private static final String BRIDGE_SIZE_LIMIT = "^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$";

    private final String input;

    public InputValidator(String input) {
        this.input = input;
    }

    public boolean isInRangeSize() {
        return input.matches(BRIDGE_SIZE_LIMIT);
    }
}
