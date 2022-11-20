package bridge;

public class BridgeBluePrint {

    private int size;

    public BridgeBluePrint(int size) {
        if (!BridgeRange.isWithinRange(size)) {
            throw new IllegalStateException(
                    "다리 길이는 " + BridgeRange.getMinValue() + "보다 크거나 같고 " + BridgeRange.getMaxValue()
                            + "보다 작거나 같아야 합니다.");
        }
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
