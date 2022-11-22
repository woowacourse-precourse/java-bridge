package bridge.data;

public enum BridgeDirection {
    DOWN_NUMBER(0),
    UP_NUMBER(1);

    private final int number;

    BridgeDirection(int number) {
         this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
