package bridge.view;

public enum BridgeFlag {

    FAIL(1), SUCCESS(2);
    private final int number;
    BridgeFlag(int number) {
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
}
