package bridge.model;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int INIT_LOCATION = -1;
    private static final int INIT_RETRY_COUNT = 1;
    private static final int COUNT_NUM = 1;
    private static final int INDEX_PLUS = 1;
    private static BridgeComparator bridgeComparator = new BridgeComparator();
    private static BridgeCalculator bridgeCalculator = new BridgeCalculator();
    private final List<String> bridge;
    private BridgeMap bridgeMap;
    private int location;
    private int retryCount;

    private BridgeGame(int size) {
        this.location = bridgeCalculator.getInitLocation();
        this.retryCount = bridgeCalculator.getInitRetryCount();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        bridgeMap = BridgeMap.createBridgeMap(size);
    }

    public static BridgeGame createBridgeGame(int size) {
        return new BridgeGame(size);
    }

    public int getRetryCount() {
        return retryCount;
    }

    public int getLocation() {
        return location;
    }

    public List<List<String>> getMap() {
        return bridgeMap.getBridgeMap();
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
        location = bridgeCalculator.countNum(location);
    }


    public boolean checkEndPoint() {
        if (bridgeComparator.isEndPoint(bridge, location)) {
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
        bridgeMap = BridgeMap.createBridgeMap(size);
    }

    private void initLocation() {
        location = bridgeCalculator.getInitLocation();
    }

    public boolean isFail() {
        return bridgeComparator.isExpressionX(location, bridgeMap.getBridgeMap());
    }

    public void countRetry() {
        retryCount = bridgeCalculator.countNum(retryCount);
    }

}
