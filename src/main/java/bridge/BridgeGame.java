package bridge;

import type.BridgeType;
import type.MovingType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge upperBridge = new Bridge(new ArrayList<>());
    private Bridge lowerBridge = new Bridge(new ArrayList<>());

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Map<String, Bridge> move(Bridge bridge, int index, String input) {
        if (input.equals(BridgeType.UPPER.getName())) {
            return getMovedBridge(bridge.compareTo(index, input), MovingType.BLANK.getResult());
        }
        return getMovedBridge(MovingType.BLANK.getResult(), bridge.compareTo(index, input));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public Bridge setBridge(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private Map<String, Bridge> getMovedBridge(String upper, String lower) {
        addBridge(upper, lower);
        Map<String, Bridge> bridges = new HashMap<>();
        bridges.put("upperBridge", upperBridge);
        bridges.put("lowerBridge", lowerBridge);
        return bridges;
    }

    private void addBridge(String upper, String lower) {
        upperBridge.addBridge(upper);
        lowerBridge.addBridge(lower);

    }
}
