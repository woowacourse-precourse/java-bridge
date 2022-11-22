package bridge;

public enum Moving {

    UP("U", 1),
    DOWN("D", 0);

    private final String mark;
    private final int bridgeNumber;

    Moving(String mark, int bridgeNumber) {
        this.mark = mark;
        this.bridgeNumber = bridgeNumber;
    }
}
