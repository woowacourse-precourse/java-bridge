package bridge;

public enum Key {
    U("U"), D("D");
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

    public static boolean matchDown(String input) {
        return input.equals(D.getValue());
    }

    public static boolean matchDown(Key input) {
        return input == D;
    }
}
