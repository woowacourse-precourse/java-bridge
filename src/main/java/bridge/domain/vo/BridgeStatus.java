package bridge.domain.vo;

public enum BridgeMap {
    U("U", 1),
    D("D", 0);

    private final String movingValue;
    private final int makerValue;

    BridgeMap(String movingValue, int makerValue) {
        this.movingValue = movingValue;
        this.makerValue = makerValue;
    }

    public static String getMovingValue(int makerValue) {
        if (BridgeMap.U.makerValue == makerValue) {
            return U.movingValue;
        }
        return D.movingValue;
    }
}
