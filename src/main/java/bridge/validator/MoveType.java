package bridge.validator;

public enum MoveType {
    UP_MOVING("U"),
    DOWN_MOVING("D");

    private final String value;

    MoveType(String value) {
        this.value = value;
    }
    public static boolean isValidInput(String input) {
        return UP_MOVING.value.equals(input) || DOWN_MOVING.value.equals(input);
    }

    public String getValue() {
        return value;
    }
}
