package bridge.constant;

import java.util.Objects;

public enum UpDownConstant {
    UP("위", "U", 1, 0),
    DOWN("아래", "D", 0, 1);

    private final String location;
    private final String symbol;
    private final int numericSymbol;
    private final int row;

    UpDownConstant(String location, String symbol, int numericSymbol, int row) {
        this.location = location;
        this.symbol = symbol;
        this.numericSymbol = numericSymbol;
        this.row = row;
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
        return row;
    }

    public boolean isSameRow(int row) {
        return row == getRow();
    }

    public static boolean contains(String symbol) {
        return Objects.equals(symbol, UP.getSymbol()) || Objects.equals(symbol, DOWN.getSymbol());
    }


}
