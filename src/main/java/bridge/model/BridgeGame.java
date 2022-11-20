package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeComparator;
import bridge.model.BridgeMaker;
import bridge.model.BridgeMap;

import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final BridgeComparator bridgeComparator;
    private BridgeMap bridgeMap;
    private int location;
    private int retryCount;

    public int getRetryCount() {
        return retryCount;
    }

    public int getLocation() {
        return location;
    }

    public List<String> getUpBridge() {
        return Collections.unmodifiableList(bridgeMap.getBridgeUpMap());
    }

    public List<String> getDownBridge() {
        return Collections.unmodifiableList(bridgeMap.getBridgeDownMap());
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public BridgeGame(int size) {
        this.location = -1;
        this.retryCount = 1;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        bridgeComparator = new BridgeComparator();
        bridgeMap = new BridgeMap(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        countLocation();
        String expression = bridgeComparator.compareBridge(bridge, moving, location);
        bridgeMap.makeBridgeMap(location, moving, expression);
    }

    private void countLocation() {
        location += 1;
    }


    public boolean checkEndPoint() {
        if (bridge.size() == location + 1) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int size) {
        countRetry();
        initLocation();
        bridgeMap = new BridgeMap(size);
    }

    private void initLocation() {
        location = -1;
    }

    public boolean isClosed() {
        return bridgeComparator.isExpressionX(location, bridgeMap.getBridgeUpMap(), bridgeMap.getBridgeDownMap());
    }

    public void countRetry() {
        retryCount += 1;
    }

}
