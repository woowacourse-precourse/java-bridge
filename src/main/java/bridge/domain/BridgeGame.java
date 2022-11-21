package bridge.domain;

import bridge.BridgeMaker;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> generateBridge;
    private final List<String> userCrossBridge;
    private final BridgeLog bridgeLog;

    public BridgeGame(int bridgeSize) {
        this(BridgeMaker.getInstanceByRandomGenerator(), bridgeSize);
    }

    public BridgeGame(BridgeMaker bridgeMaker, int bridgeSize) {
        this.generateBridge = bridgeMaker.makeBridge(bridgeSize);
        this.userCrossBridge = new ArrayList<>(bridgeSize);
        this.bridgeLog = new BridgeLog();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveKey) {
        userCrossBridge.add(moveKey);
        bridgeLog.addLog(generateBridge.get(userCrossBridge.size() - 1), moveKey);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userCrossBridge.clear();
        bridgeLog.clear();
    }

    /**
     * 사용자가 건넌 다리가 건널수있는 다리인지 확인하는 메서드
     */
    public boolean isMovable() {
        return isMovable(userCrossBridge.size() - 1);
    }

    /**
     * 사용자가 건넌 다리가 건널수있는 다리인지 인덱스별로 확인하는 메서드
     */
    public boolean isMovable(int userCrossBridgeIndex) {
        return generateBridge.get(userCrossBridgeIndex).equals(userCrossBridge.get(userCrossBridgeIndex)) && !isEnd();
    }

    /**
     * 게임이 끝났는지 확인하는 메서드
     */
    public boolean isEnd() {
        return generateBridge.size() <= userCrossBridge.size();
    }

    /**
     * 게임 라운드 확인 메서드
     * [ O | O | O ] => 3라운드
     */
    public int getRound() {
        return userCrossBridge.size();
    }

    /**
     * 사용자 다리 건넌 기록 반환 메서드
     */
    public BridgeLog getLog() {
        return bridgeLog;
    }
}
