package bridge;

import type.MovingType;

import java.util.HashMap;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridges bridges = new Bridges();
    private Retry retry = new Retry(1);

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, Moving input) {
        if (input.isUpper()) {
            bridges.moveUpperBridge(input.isMoving(bridge, bridges.getSize()));
            return;
        }
        bridges.moveLowerBridge(input.isMoving(bridge, bridges.getSize()));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        retry.add();
        bridges.delete();
    }

    public Bridge setBridge(int size) {
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
