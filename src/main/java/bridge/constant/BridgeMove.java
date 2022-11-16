package bridge.constant;

public enum BridgeMove {

    DOWN(0, "D"),
    UP(1, "U"),
    MISS(-1, "M"),
    ;

    private final int symbolicNumber;
    private final String firstLetter;

    BridgeMove(int symbolicNumber, String firstLetter) {
        this.symbolicNumber = symbolicNumber;
        this.firstLetter = firstLetter;
    }

    public int getSymbolicNumber() {
        return symbolicNumber;
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}
