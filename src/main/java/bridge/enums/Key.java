package bridge.enums;

public enum Key {
    U("U"), D("D"), R("R"), Q("Q");

    private final String value;

    Key(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean matchUp(String input) {
        return input.equals(U.getValue());
    }

    public static boolean matchUp(Key input) {
        return input == U;
    }

    public static boolean matchDown(Key input) {
        return input == D;
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
