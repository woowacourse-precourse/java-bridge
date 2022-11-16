package bridge;

import java.util.Arrays;

public enum BridgePoint {
    UP(1, "U"),
    DOWN(0, "D");

    private final int pointNumber;
    private final String point;

    BridgePoint(int pointNumber, String point) {
        this.pointNumber = pointNumber;
        this.point = point;
    }

    public static BridgePoint createPoint(int pointNumber) {
        return Arrays.stream(values())
                .filter(pointValue -> pointValue.pointNumber == pointNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 정보입니다."));
    }

    public String getPoint() {
        return point;
    }
}
