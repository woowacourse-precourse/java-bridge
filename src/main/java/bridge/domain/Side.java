package bridge.domain;

public enum Side {
    UP(1,"U"),
    DOWN(0,"D"),
    ;

    private int sideOfNumber;
    private String sideOfString;

    Side(int sideOfNumber, String sideOfString) {
        this.sideOfNumber = sideOfNumber;
        this.sideOfString = sideOfString;
    }

    public int ofNumber() {
        return sideOfNumber;
    }

    public String ofString() {
        return sideOfString;
    }
}
