package bridge;

public enum BridgeStatus {
    UP(1, "U"),
    DOWN(0, "D");

    private final int upNumber;
    private final String upName;

    BridgeStatus(int upNumber,String upName) {
        this.upName = upName;
        this.upNumber = upNumber;
    }

    public int getUpNumber() {
        return upNumber;
    }

    public String getUpName() {
        return upName;
    }
}
