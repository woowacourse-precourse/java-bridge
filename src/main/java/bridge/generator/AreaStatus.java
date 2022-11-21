package bridge.generator;

public enum AreaStatus {
    UP("U", 1),
    DOWN("D", 0);

    private final String symbol;
    private final int status;

    AreaStatus(String symbol, int status) {
        this.symbol = symbol;
        this.status = status;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getStatus() {
        return status;
    }

    public static AreaStatus getAreaStatus(int status) {
        if (status == UP.status) {
            return UP;
        }
        if (status == DOWN.status) {
            return DOWN;
        }
        return null;
    }
}
