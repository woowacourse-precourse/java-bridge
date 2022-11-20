package bridge.generator;

public enum AreaStatus {
    UP("U", 1),
    DOWN("D", 0);

    public final String symbol;
    public final int status;

    AreaStatus(String symbol, int status) {
        this.symbol = symbol;
        this.status = status;
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
