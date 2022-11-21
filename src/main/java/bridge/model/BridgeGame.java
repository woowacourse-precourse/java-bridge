package bridge.model;

import bridge.BridgeRandomNumberGenerator;

import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int INIT_LOCATION=-1;
    private static final int INIT_RETRY_COUNT=1;
    private static final int COUNT_NUM=1;
    private static final int INDEX_PLUS=1;
    private final List<String> bridge;
    private final BridgeComparator bridgeComparator;
    private BridgeMap bridgeMap;
    private int location;
    private int retryCount;

    private BridgeGame(int size) {
        this.location = INIT_LOCATION;
        this.retryCount = INIT_RETRY_COUNT;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        bridgeComparator = new BridgeComparator();
        bridgeMap = BridgeMap.createBridgeMap(size);
    }

    public static BridgeGame createBridgeGame(int size){
        return new BridgeGame(size);
    }

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
        location += COUNT_NUM;
    }


    public boolean checkEndPoint() {
        if (bridge.size() == location + INDEX_PLUS) {
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
        bridgeMap =  BridgeMap.createBridgeMap(size);
    }

    private void initLocation() {
        location = INIT_LOCATION;
    }

    public boolean isClosed() {
        return bridgeComparator.isExpressionX(location, bridgeMap.getBridgeUpMap(), bridgeMap.getBridgeDownMap());
    }

    public void countRetry() {
        retryCount += COUNT_NUM;
    }

}
