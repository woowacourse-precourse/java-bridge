package bridge;

import bridge.validator.RetryInput;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge = new ArrayList<>();
    private List<String> userMoving = new ArrayList<>();

    public void initGame(List<String> bridge) {
        userMoving = new ArrayList<>();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public boolean move(String moving) {
        boolean correct = false;

        userMoving.add(moving);
        correct = isCorrect(moving);

        return correct;
    }

    private boolean isCorrect(String moving) {
        return bridge.get(getCurTile()).equals(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        return RetryInput.RETRY.getValue().equals(gameCommand);
    }

    public boolean isFinished() {
        return getCurTile() == bridge.size() - 1;
    }

    private int getCurTile() {
        return userMoving.size() - 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserMoving() {
        return userMoving;
    }
}
