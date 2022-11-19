package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private List<String> userAnswer;
    private int attempt;

    public BridgeGame() {
        this.userAnswer = new ArrayList<>();
        this.attempt = 1;
    }

    public void initBridge(int size) {
        bridge = new Bridge(size);
    }

    public Progress move(String UorD) {
        userAnswer.add(UorD);
        return compareBridgeAndUser(userAnswer.size() - 1);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private Progress compareBridgeAndUser(int currentIndex) {
        if (bridge.getBridgeIdx(currentIndex).equals(userAnswer.get(currentIndex))) {
            if (userAnswer.size() == bridge.getBridge().size()) {
                return Progress.SUCCESS;
            }
            return Progress.PROGRESSION;
        }
        return Progress.FAILURE;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public List<String> getUserAnswer() {
        return userAnswer;
    }

    public int getAttempt() {
        return attempt;
    }
}
