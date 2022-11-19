package bridge.constant;

public enum Directions {
    UP('U', 1),
    DOWN('D', 0);

    private final Character symbol;
    private final int digit;

    private Directions (Character symbol, int digit) {
        this.symbol = symbol;
        this.digit = digit;
    }

    public Character getSymbol() {
        return symbol;
    }

    public int getDigit() {
        return digit;
    }
}
