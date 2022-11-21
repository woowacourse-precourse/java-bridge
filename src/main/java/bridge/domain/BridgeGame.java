package bridge.domain;

import bridge.BridgeMaker;
import bridge.GameKeySet;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final List<String> bridgeLine;
    private final List<String> userCrossBridge;
    private final BridgeLog bridgeLog;

    public BridgeGame(int bridgeSize) {
        this(BridgeMaker.getInstanceByRandomGenerator(), bridgeSize);
    }

    public BridgeGame(BridgeMaker bridgeMaker, int bridgeSize) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeLine = bridgeMaker.makeBridge(bridgeSize);
        this.userCrossBridge = new ArrayList<>(bridgeSize);
        this.bridgeLog = new BridgeLog();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(GameKeySet moveKey) {
        move(moveKey.getKeySet());
    }

    public void move(String moveKey) {
        userCrossBridge.add(moveKey);
        bridgeLog.addLog(bridgeLine.get(userCrossBridge.size() - 1), moveKey);
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

    public boolean isMovable() {
        return isMovable(userCrossBridge.size() - 1);
    }

    /**
     * 사용자가 건넌 다리가 건널수있는 다리인지 확인하는 메서드
     */
    public boolean isMovable(int userCrossBridgeIndex) {
        return bridgeLine.get(userCrossBridgeIndex).equals(userCrossBridge.get(userCrossBridgeIndex)) && !isEnd();
    }

    /**
     * 게임이 끝났는지 확인하는 메서드
     */
    public boolean isEnd() {
        return bridgeLine.size() <= userCrossBridge.size();
    }

    public int getRound() {
        return userCrossBridge.size();
    }

    public BridgeLog getLog() {
        return bridgeLog;
    }
}
