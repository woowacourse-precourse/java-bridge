package bridge.model;

public enum Bridge {
    U, D;

    public static final String UPPER_BRIDGE_FORMAT_STRING = "U";
    public static final String LOWER_BRIDGE_FORMAT_STRING = "D";
    public static final String ERR_BRIDGE_FORMAT = "[ERROR] 윗 칸은 'U', 아랫 칸은 'D'를 입력하세요. 대소문자 구별. 예시) U(O), D(O), d(X)";

    public static Bridge toBridge(String format) {
        if (format.equals(UPPER_BRIDGE_FORMAT_STRING) || format.equals(LOWER_BRIDGE_FORMAT_STRING)) {
            return Bridge.valueOf(format);
        }
        throw new IllegalArgumentException(ERR_BRIDGE_FORMAT);
    }
}
