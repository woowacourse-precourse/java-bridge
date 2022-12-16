package bridge.util;

import java.util.Arrays;
import java.util.stream.Stream;

public enum BridgeShapeInfo {
    UP(1, "U"),
    DOWN(0, "D");

    private final int shapeNumber;
    private final String bridgeShape;

    BridgeShapeInfo(int shapeNumber, String bridgeShape) {
        this.shapeNumber = shapeNumber;
        this.bridgeShape = bridgeShape;
    }

    public int getShapeNumber() {
        return shapeNumber;
    }
    public String getBridgeShape() {
        return bridgeShape;
    }

    /**
     * 랜덤 값과 shapeNumber간 동일한 값이 존재하면 BridgeShapeInfo반환
     * @param number
     * @return BridgeShapeInfo | null
     */
    public static BridgeShapeInfo getBridgeShapeInfoWithNumber(int number) {
        for(BridgeShapeInfo shape : BridgeShapeInfo.values()) {
            if (valuesEqual(shape.getShapeNumber(), number)) {
                return shape;
            }
        }
        return null;
    }

    private static boolean valuesEqual(int origin, int compare) {
        return origin == compare;
    }
}
