package bridge.constant;

public enum BridgeLengthSizeStatus {
    BridgeLengthMin(3),
    BridgeLengthMax(20);

    private final int lengthSize;

    BridgeLengthSizeStatus(int lengthSize) {
        this.lengthSize = lengthSize;
    }

    public static boolean bridgeLengthSizeValid(int lengthSize){
        return BridgeLengthMin.lengthSize <= lengthSize && lengthSize <= BridgeLengthMax.lengthSize;
    }
}
