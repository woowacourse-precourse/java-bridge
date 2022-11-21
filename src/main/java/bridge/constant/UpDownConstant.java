package bridge.constant;

import java.util.Objects;

public enum UpDownConstant {
    UP("위", "U", 1),
    DOWN("아래", "D", 0);

    private final String location;
    private final String symbol;
    private final int numericSymbol;

    UpDownConstant(String location, String symbol, int numericSymbol) {
        this.location = location;
        this.symbol = symbol;
        this.numericSymbol = numericSymbol;
    }

    public static UpDownConstant of(String symbol) {
        if (Objects.equals(symbol, UP.getSymbol())) {
            return UP;
        } else if (Objects.equals(symbol, DOWN.getSymbol())) {
            return DOWN;
        }
        throw new IllegalArgumentException(ErrorStringConstant.UP_OR_DOWN_INPUT_ERROR_MESSAGE.getError());
    }

    public static UpDownConstant of(int numericSymbol) {
        if (numericSymbol == UP.getNumericSymbol()) {
            return UP;
        } else if (numericSymbol == DOWN.getNumericSymbol()) {
            return DOWN;
        }
        throw new IllegalArgumentException(ErrorStringConstant.UP_OR_DOWN_INPUT_ERROR_MESSAGE.getError());
    }

    public String getSymbol() {
        return symbol;
    }

    public String getLocation() {
        return location;
    }

    public int getNumericSymbol() {
        return numericSymbol;
    }
    private int getRow() {
        return (numericSymbol + 1) % 2;
    }

    public boolean isSameRow(int row) {
        return row == getRow();
    }

    public static boolean contains(String symbol) {
        return Objects.equals(symbol, UP.getSymbol()) || Objects.equals(symbol, DOWN.getSymbol());
    }


}
