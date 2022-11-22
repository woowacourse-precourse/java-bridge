package bridge.utils;

import java.text.DecimalFormat;

public enum Constant {

    UPPER("U"),
    DOWN("D"),
    RIGHT("O"),
    WRONG("X"),
    NOT_MATCH(" "),
    RETRY("R"),
    QUIT("Q"),
    SUCCESS("성공"),
    FAIL("실패");

    public String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
