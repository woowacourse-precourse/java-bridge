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

    public static boolean matchUp(String input) {
        return input.equals(U.getValue());
    }

    public static boolean matchDown(String input) {
        return input.equals(D.getValue());
    }

    public static boolean matchRetry(String input) {
        return input.equals(R.getValue());
    }

    public static boolean matchQuit(String input) {
        return input.equals(Q.getValue());
    }
}
