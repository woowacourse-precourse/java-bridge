package bridge.models;

import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private int currentIndex = -1;
    private boolean gameContinue = true;
    private int trialCount = 1;

    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public boolean isGameContinue() {
        return gameContinue;
    }

    public int getTrialCount() {
        return trialCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        currentIndex++;
        if (!checkDirection(direction)) {
            gameContinue = false;
        }
    }

    private boolean checkDirection(String direction) {
        return bridge.get(currentIndex).equals(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        trialCount++;
        gameContinue = true;
        currentIndex = -1;
    }

    public boolean isGameSuccess() {
        return ((currentIndex == (bridge.size() - 1)) && gameContinue);
    }
}
