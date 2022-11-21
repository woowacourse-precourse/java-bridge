package bridge.domain.common;

public enum Side {

    UP(1,"U"),
    DOWN(0,"D"),
    ;

    private final int sideOfNumber;
    private final String sideOfString;

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
