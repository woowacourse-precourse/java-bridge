package bridge.enums;

/**
 * 필요한 기호
 */
public enum Sign {
    CORRECT("O"),
    WRONG("X"),
    BLANK(" "),
    UP("U"),
    DOWN("D"),
    ;

    private final String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
