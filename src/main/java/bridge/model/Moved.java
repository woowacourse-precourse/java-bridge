package bridge.model;

public enum Moved {
    CANT(0),
    CAN(1),
    NOTYET(2);

    private final Integer movedFlag;

    Moved(Integer movedFlag) {
        this.movedFlag = movedFlag;
    }

    public Integer getMovedFlag() {
        return movedFlag;
    }
}
