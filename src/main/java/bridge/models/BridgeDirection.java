package bridge.models;

public enum BridgeDirection {
    UP("U", 1),
    DOWN("D", 0);

    private String capital;

    private int number;

    BridgeDirection(String capital, int number) {
        this.capital = capital;
        this.number = number;
    }

    public static String numberToCapital(int number) {
        for (BridgeDirection bridgeDirection : BridgeDirection.values()) {
            if (bridgeDirection.number == number) {
                return bridgeDirection.capital;
            }
        }
        return null;
    }
}
