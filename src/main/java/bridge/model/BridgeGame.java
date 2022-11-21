package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int repeatCount;
    private int currPosition;
    private final List<String> bridge;
    private final BridgeStatus bridgeStatus;

    public BridgeGame(List<String> bridge) {
        repeatCount = 1;
        currPosition = 0;
        this.bridge = bridge;
        bridgeStatus = new BridgeStatus();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String move) {
        String currBridge = bridge.get(currPosition);
        boolean correct = currBridge.equals(move);
        bridgeStatus.update(move, correct);
        if (correct) {
            currPosition++;
        }
        return correct;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeStatus.clear();
        repeatCount++;
        currPosition = 0;
    }

    /**
     * 현재 게임의 상태를 반환하는 메서드
     */
    public BridgeStatus getStatus() {
        return bridgeStatus;
    }

    /**
     * 게임 반복 횟수를 반환하는 메서드
     */
    public int getRepeatCount() {
        return repeatCount;
    }
}
