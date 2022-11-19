package bridge.validator;

public enum RetryInput{
    RETRY("R"),
    QUIT("Q");

    private final String value;

    RetryInput(String value) {
        this.value = value;
    }

    public static boolean isValidInput(String input) {
        return RETRY.value.equals(input) || QUIT.value.equals(input);
    }

    public String getValue() {
        return value;
    }
}
