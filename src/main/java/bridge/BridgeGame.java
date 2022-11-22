package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeMap;
import bridge.type.BridgeGameCommandType;
import bridge.type.BridgeSideType;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * InputView와 OutputView는 사용할 수 없다.
 */
public class BridgeGame {
    private final static int ONE = 1;
    private final static String SUCCESS = "성공";
    private final static String FAIL = "실패";
    private int compareCount = 0;
    private int challengeCount = 1;
    private boolean challengeResult = false;

    private final Bridge bridge = new Bridge();
    private BridgeMap bridgeMap = new BridgeMap();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeMap move(String bridgeSide) {
        addBridgeMap(bridgeSide);
        compareCount++;

        return bridgeMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(BridgeGameCommandType gameCommandType) {
        if(gameCommandType.getIsRetry()) {
            bridgeMap = new BridgeMap();
            compareCount = 0;
            challengeCount++;
            return;
        }
    }

    public boolean isFinish(String bridgeSide) {
        if(bridge.isLastCount(compareCount) || !bridge.isMatchBothIndexAndString(bridgeSide, compareCount - ONE)) {
            if(bridge.isLastCount(compareCount) && bridge.isMatchBothIndexAndString(bridgeSide, compareCount - ONE)) {
                challengeResult = true;
            }
            return false;
        }
        return true;
    }

    public String getChallengeResultToString() {
        if(challengeResult == true) {
            return SUCCESS;
        }
        return FAIL;
    }

    public void createAndRegisterBridge(int bridgeSize) {
        bridge.registerBridge(bridge.createBridge(bridgeSize));
    }

    private void addBridgeMap(String bridgeSide) {
        if(bridgeSide.equals(BridgeSideType.UPPER_SIDE.getSide())) {
            bridgeMap.addUpperBridge(bridge.isMatchBothIndexAndString(bridgeSide, compareCount));
            return;
        }
        bridgeMap.addLowerBridge(bridge.isMatchBothIndexAndString(bridgeSide, compareCount));
        return;
    }

    public BridgeMap getFinishBridgeMap() {
        return bridgeMap;
    }

    public Integer getChallengeCount() {
        return challengeCount;
    }

    public boolean getChallengeResult() { return challengeResult; }
}
