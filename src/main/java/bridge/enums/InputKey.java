package bridge.enums;

public enum InputKey {
    U("U"), D("D"), R("R"), Q("Q");

    private final String value;

    InputKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isUp(String input) {
        return input.equals(U.getValue());
    }

    public static boolean isDown(String input) {
        return input.equals(D.getValue());
    }

    public static boolean isRetry(String input) {
        return input.equals(R.getValue());
    }

    public static boolean isQuit(String input) {
        return input.equals(Q.getValue());
    }
}
