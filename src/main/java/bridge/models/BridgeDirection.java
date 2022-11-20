package bridge.models;

public enum BridgeDirection {
    UP("U", 1),
    DOWN("D", 0),
    ERROR("E", -1);

    private final String capital;
    private final int number;

    BridgeDirection(String capital, int number) {
        this.capital = capital;
        this.number = number;
    }

    public String getCapital() {
        return capital;
    }

    // TODO BridgeDirection Enum 구조 고찰해보기
    public static BridgeDirection getDirection(int number) {
        for (BridgeDirection bridgeDirection : BridgeDirection.values()) {
            if (bridgeDirection.number == number) {
                return bridgeDirection;
            }
        }
        return ERROR;
    }
}
