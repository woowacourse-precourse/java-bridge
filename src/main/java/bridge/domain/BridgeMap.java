package bridge.domain;

import java.util.Arrays;

public class BridgeMap {
    private static final int UP_BRIDGE = 0;
    private static final int DOWN_BRIDGE = 1;
    private static final int BRIDGE_TYPE_SIZE = 2;
    private static final String UP = "U";
    private static final String DOWN = "D";
    public BridgeStatus[][] bridgeStatuses;

    public BridgeMap(int bridgeSize) {
        this.bridgeStatuses = new BridgeStatus[BRIDGE_TYPE_SIZE][bridgeSize];
        setUpMap();
    }

    public void reflectAtMap(String direction, int currentBridgeCoordinate, BridgeStatus bridgeBlockStatus) {
        if (direction.equals(UP)) {
            bridgeStatuses[UP_BRIDGE][currentBridgeCoordinate] = bridgeBlockStatus;
        }
        if (direction.equals(DOWN)) {
            bridgeStatuses[DOWN_BRIDGE][currentBridgeCoordinate] = bridgeBlockStatus;
        }
    }

    public void setUpMap() {
        Arrays.stream(bridgeStatuses).forEach(row -> Arrays.fill(row, BridgeStatus.INIT));
    }
}