package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Command.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<List<String>> result = new ArrayList<>();
    private final List<String> bridge;
    private boolean gameEnd = false;
    private int movingCount = 0;
    private int gameCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (isBridgeEquals(moving)) {
            addMovingResult(moving);
            return;
        }

        addFailMovingResult(moving);
        gameEnd = true;
    }

    private boolean isBridgeEquals(String moving) {
        if (bridge.get(movingCount).equals(moving)) {
            movingCount++;
            return true;
        }

        return false;
    }

    private void addMovingResult(String moving) {
        if (UP.isEquals(moving)) {
            addLetterToFirstFloor(RESULT_SUCCESS.getMessage());
            return;
        }

        addLetterToSecondFloor(RESULT_SUCCESS.getMessage());
    }

    private void addLetterToFirstFloor(String letter) {
        result.get(0).add(letter);
        result.get(1).add(BLANK_SPACE.getMessage());
    }

    private void addLetterToSecondFloor(String letter) {
        result.get(0).add(BLANK_SPACE.getMessage());
        result.get(1).add(letter);
    }

    private void addFailMovingResult(String moving) {
        if (UP.isEquals(moving)) {
            addLetterToFirstFloor(RESULT_FAIL.getMessage());
            return;
        }

        addLetterToSecondFloor(RESULT_FAIL.getMessage());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (isRetryEquals(gameCommand)) {
            gameCount++;
            initRetryGame();
            return true;
        }

        return false;
    }

    private boolean isRetryEquals(String command) {
        return command.equals(RETRY.getMessage());
    }

    private void initRetryGame() {
        movingCount = 0;
        gameEnd = false;
        result.get(0).clear();
        result.get(1).clear();
    }

    public String isSuccess() {
        if (isFinishBridge()) {
            return SUCCESS.getMessage();
        }

        return FAIL.getMessage();
    }

    public boolean isFinishBridge() {
        return bridge.size() == movingCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public List<List<String>> getResult() {
        return result;
    }
}
