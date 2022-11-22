package bridge.model;

public enum Moved {
    CANT(0,"X"),
    CAN(1,"O"),
    NOTYET(2," ");

    private final Integer movedFlag;
    private final String oOrX;
    Moved(Integer movedFlag,String oOrX) {
        this.movedFlag = movedFlag;
        this.oOrX = oOrX;
    }

    public String getoOrX() {
        return oOrX;
    }
}
