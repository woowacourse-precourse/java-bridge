package bridge.model;

public enum Moving {
    U, D;

    public static final String UP_MOVING_FORMAT_STRING = "U";
    public static final String DOWN_MOVING_FORMAT_STRING = "D";
    public static final String ERR_MOVING_FORMAT = "[ERROR] 윗 칸은 'U', 아랫 칸은 'D'를 입력하세요. 대소문자 구별. 예시) U(O), D(O), d(X)";

    public static Moving toMoving(String format) {
        if (format.equals(UP_MOVING_FORMAT_STRING) || format.equals(DOWN_MOVING_FORMAT_STRING)) {
            return Moving.valueOf(format);
        }
        throw new IllegalArgumentException(ERR_MOVING_FORMAT);
    }
}
