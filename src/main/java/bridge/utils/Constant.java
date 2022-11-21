package bridge.utils;

import java.text.DecimalFormat;

public enum Constant {

    UPPER("U"),
    DOWN("D"),
    RIGHT("O"),
    WRONG("X"),
    NOT_MATCH(" "),
    RETRY("R"),
    QUIT("Q");

    public Object value;

    Constant(Object value) {
        this.value = value;
    }

    public Object getvalue() {
        return value;
    }
}
