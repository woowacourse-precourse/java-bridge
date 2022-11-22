package bridge.domain.constant;

import bridge.constant.ErrorMessage;

import java.util.Arrays;

public enum Directions {
    UP("U", 1),
    DOWN("D", 0);

    private final String symbol;
    private final int digit;

    public static String convertDigitToSymbol (int digit) {
        return Arrays.stream(Directions.values())
                .filter(directions -> directions.getDigit() == digit)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION_DIGIT_ARGUMENT.get()))
                .getSymbol();
    }

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
