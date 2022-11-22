package bridge;

public enum BridgeEnum {
    D(0),
    U(1);

    int upDown;

    BridgeEnum(int upDown) {
        this.upDown = upDown;
    }
}
