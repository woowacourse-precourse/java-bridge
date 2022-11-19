package bridge.constant;

import java.util.Arrays;

public enum Directions {
    UP("U", 1),
    DOWN("D", 0);

    private final String symbol;
    private final int digit;

    private Directions (String symbol, int digit) {
        this.symbol = symbol;
        this.digit = digit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getDigit() {
        return digit;
    }
}
