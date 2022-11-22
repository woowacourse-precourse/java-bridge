package bridge;

public enum Key {
    U("U"), D("D"),
    R("R"), Q("Q");
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

    public static boolean matchEnd(String input) {
        return input.equals(Q.getValue());
    }
}
