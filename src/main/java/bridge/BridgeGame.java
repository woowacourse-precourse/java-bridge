package bridge;

import type.MovingType;

import java.util.Map;

public class BridgeGame {
    private Bridges bridges = new Bridges();
    private Retry retry = new Retry(1);

    public void move(Bridge bridge, Moving input) {
        if (input.isUpper()) {
            bridges.moveUpperBridge(input.isMoving(bridge, bridges.getSize()));
            return;
        }
        bridges.moveLowerBridge(input.isMoving(bridge, bridges.getSize()));
    }

    public void retry() {
        retry.add();
        bridges = new Bridges();
    }

    public Bridge setBridge(BridgeSize size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    public Map<String, Bridge> getMovedBridge() {
        return bridges.get();
    }

    public boolean isMoving(Bridge bridge, Moving input) {
        if (input.isMoving(bridge, bridges.getSize() - 1).equals(MovingType.MOVE.getResult()))
            return true;
        return false;
    }

    public boolean isFinish(Bridge bridge) {
        if (bridge.getSize() == bridges.getSize()) {
            return true;
        }
        return false;
    }

    public String getResult(Bridge bridge) {
        if (isFinish(bridge)) {
            return "성공";
        }
        return "실패";
    }

    public String getNumberOfRetry() {
        return retry.toString();
    }
}
