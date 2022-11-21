package bridge.domain;

import java.util.Arrays;

public class BridgeMap2 {
    public BridgeStatus[][] bridgeStatuses;

    public BridgeMap2(int bridgeSize) {
        this.bridgeStatuses = new BridgeStatus[2][bridgeSize];
        Arrays.stream(bridgeStatuses).forEach(row -> Arrays.fill(row, BridgeStatus.INIT));
    }

    public void reflectAtMap(String direction, int currentBridgeBlock, BridgeStatus bridgeBlockStatus) {
        if (direction.equals("U")) {
            bridgeStatuses[0][currentBridgeBlock] = bridgeBlockStatus;
        }
        if (direction.equals("D")) {
            bridgeStatuses[1][currentBridgeBlock] = bridgeBlockStatus;
        }
    }

    public void clear() {
        Arrays.stream(bridgeStatuses).forEach(row -> Arrays.fill(row, BridgeStatus.INIT));
    }
}
