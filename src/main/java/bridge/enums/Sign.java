package bridge.enums;

/**
 * 필요한 기호
 */
public enum Sign {
    DOWN("D"),
    UP("U"),
    CORRECT("O"),
    WRONG("X"),
    BLANK(" "),
    ;

    private final String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static String getSign(int index) {
        return Sign.values()[index].sign;
    }
}
