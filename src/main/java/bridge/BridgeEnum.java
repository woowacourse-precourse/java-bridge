package bridge;

public enum BridgeEnum {
    U(1), D(0);

    private final int num;

    BridgeEnum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
