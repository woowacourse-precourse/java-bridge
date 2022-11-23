package bridge.EnumCollections;

public enum BridgeLengthType {
    MIN(3),
    MAX(20);

    private int length;

    BridgeLengthType(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
