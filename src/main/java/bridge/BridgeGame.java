package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * InputView와 OutputView는 사용할 수 없다.
 */
public class BridgeGame {
    private int compareCount = 0;

    private final static Bridge bridge = new Bridge();
    private final BridgeMap bridgeMap = new BridgeMap();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMap move(String bridgeSide) {
        addBridgeMap(bridgeSide);
        System.out.println(bridge.getBridge());

        return bridgeMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    public boolean isFinish(String bridgeSide) {
        if(bridge.isLastCount(compareCount) || !bridge.isMatchBothIndexAndString(bridgeSide, compareCount)) {
            return false;
        }
        compareCount++;
        return true;
    }

    public void createBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator= new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        List<String> newBridge = bridgeMaker.makeBridge(bridgeSize);
        bridge.registerBridge(newBridge);
    }

    private void addBridgeMap(String bridgeSide) {
        if(bridgeSide.equals(BridgeSideType.UP_STAIRS.getSide())) {
            bridgeMap.addUpperBridge(bridge.isMatchBothIndexAndString(bridgeSide, compareCount));
            return;
        }
        bridgeMap.addLowerBridge(bridge.isMatchBothIndexAndString(bridgeSide, compareCount));
        return;
    }


}
