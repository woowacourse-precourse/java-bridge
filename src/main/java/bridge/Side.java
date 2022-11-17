package bridge;

public enum Side {
    UP(0,"U"),
    DOWN(1,"D"),
    ;

    private int sideOfNumber;
    private String sideOfString;

    Side(int sideOfNumber, String sideOfString) {
        this.sideOfNumber = sideOfNumber;
        this.sideOfString = sideOfString;
    }

    int ofNumber() {
        return sideOfNumber;
    }

    String ofString() {
        return sideOfString;
    }
}
