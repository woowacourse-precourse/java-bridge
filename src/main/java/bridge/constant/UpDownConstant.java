package bridge.constant;

public enum UpDownConstant {
    UP("위", "U"),
    DOWN("아래", "D");


    private String status;
    private String symbol;

    UpDownConstant(String status, String symbol) {
        this.status = status;
        this.symbol = symbol;
    }

    public static UpDownConstant of(String symbol) {
        if (symbol == UP.getSymbol()) {
            return UP;
        } else if (symbol == DOWN.getSymbol()) {
            return DOWN;
        }
        throw new IllegalArgumentException(ErrorStringConstant.UP_OR_DOWN_INPUT_ERROR_MESSAGE.getError());
    }

    public String getSymbol() {
        return symbol;
    }

    public String getStatus() {
        return status;
    }
}
