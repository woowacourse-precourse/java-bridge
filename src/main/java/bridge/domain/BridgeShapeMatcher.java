package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

public enum BridgeShapeMatcher {
    UP_TRUE("U",true, "O", " "),
    UP_FALSE("U",false,"X", " "),
    DOWN_TRUE("D",true, " " , "O"),
    DOWN_FALSE("D",false, " " , "X"),
    NONE(null, false, " ", " ");

    private String direction;
    private boolean isTrue;
    private String upFloor;
    private String downFloor;

    BridgeShapeMatcher(String direction, boolean isTrue, String upFloor, String downFloor) {
        this.direction = direction;
        this.isTrue = isTrue;
        this.upFloor = upFloor;
        this.downFloor = downFloor;
    }

    public static BridgeShapeMatcher findBridgeShape(String shapeKeyword, boolean isTrue){
        return Arrays.stream(BridgeShapeMatcher.values())
                .filter(bridgeShape -> Objects.equals(bridgeShape.direction, shapeKeyword))
                .filter(bridgeShape -> Objects.equals(bridgeShape.isTrue, isTrue))
                .findAny()
                .orElse(NONE);
    }

    public String getUpFloor() {
        return upFloor;
    }

    public String getDownFloor() {
        return downFloor;
    }
}
