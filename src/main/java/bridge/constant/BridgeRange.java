package bridge.constant;

public enum BridgeRange {

    MIN_LENGTH(3)
    , MAX_LENGTH(20)
    ;

    private final Integer number;

    BridgeRange(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
