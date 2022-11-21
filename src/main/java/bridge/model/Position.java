package bridge.model;

public enum Position {
    UP, DOWN;

    public static final String ERROR_ENUM_STRING_TYPE = "잘못된 문자입니다.";
    public static final String POSITION_UP = "U";
    public static final String POSITION_DOWN = "D";

    public static Position create(String position) {
        if (position.equals(POSITION_UP)) {
            return UP;
        }
        if (position.equals(POSITION_DOWN)) {
            return DOWN;
        }
        throw new IllegalArgumentException(ERROR_ENUM_STRING_TYPE);
    }
}
