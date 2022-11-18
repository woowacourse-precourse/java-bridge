package bridge.domain.vo;

public enum BridgeStatus {
    U("U", 1),
    D("D", 0);

    private final String movingValue;
    private final int makerValue;

    BridgeStatus(String movingValue, int makerValue) {
        this.movingValue = movingValue;
        this.makerValue = makerValue;
    }

    public static String makerValueToMovingValue(int makerValue) {
        if (BridgeStatus.U.makerValue == makerValue) {
            return U.movingValue;
        }
        return D.movingValue;
    }
}
