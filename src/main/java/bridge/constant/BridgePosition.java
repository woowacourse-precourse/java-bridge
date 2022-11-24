package bridge.constant;

public enum BridgePosition {

    UP("U", 1),
    DOWN("D", 0);

    private final String positionFormOfAlphabet;
    private final int positionFormOfNumber;

    BridgePosition(String positionFormOfAlphabet, int positionFormOfNumber) {
        this.positionFormOfAlphabet = positionFormOfAlphabet;
        this.positionFormOfNumber = positionFormOfNumber;
    }

    public String getPositionFormOfAlphabet() {
        return positionFormOfAlphabet;
    }

    public int getPositionFormOfNumber() {
        return positionFormOfNumber;
    }
}
