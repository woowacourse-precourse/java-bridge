package bridge;

import java.util.List;

import static bridge.View.Constants.OutputConstants.RIGHT;
import static bridge.View.Constants.OutputConstants.WRONG;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private User user;
    private int attempt;
    private boolean success;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.user = new User();
        this.attempt = 1;
        this.success = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        boolean resultOfStep = isResultOfStep(direction);
        String OorX = convertResultOfStepToString(resultOfStep);
        user.addPathOfBridge(direction, OorX);
        return resultOfStep;
    }

    public void checkSuccess() {
        if (bridge.size() == user.getRound()) {
            success = true;
        }
    }

    public boolean isResultOfStep(String direction) {
        int round = user.getRound();
        return bridge.get(round).equals(direction);
    }

    public String convertResultOfStepToString(boolean resultOfStep) {
        if (resultOfStep) {
            return RIGHT;
        }
        return WRONG;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user = new User();
        plusAttempt();
    }

    private void plusAttempt() {
        attempt++;
    }

    public int getAttempt() {
        return this.attempt;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public User getUser() {
        return user;
    }
}
