package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final static String SUCCESS = "성공";
    private final static String FAIL = "실패";
    private final static String RESULT_SUCCESS = "O";
    private final static String RESULT_FAIL = "X";
    private final static String UP = "U";
    private final static String RETRY = "R";
    private final static String BLANK_SPACE = " ";


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
        if (isBridgeEqulas(moving)) {
            addMovingResult(moving);
            return;
        }
        addFailMovingResult(moving);
        gameEnd = true;
    }

    private boolean isBridgeEqulas(String moving) {
        if (bridge.get(movingCount).equals(moving)) {
            movingCount++;
            return true;
        }
        return false;
    }

    private void addMovingResult(String moving) {
        if (moving.equals(UP)) {
            addLetterToFirstFloor(RESULT_SUCCESS);
            return;
        }
        addLetterToSecondFloor(RESULT_SUCCESS);
    }

    private void addLetterToFirstFloor(String letter) {
        result.get(0).add(letter);
        result.get(1).add(BLANK_SPACE);
    }

    private void addLetterToSecondFloor(String letter) {
        result.get(0).add(BLANK_SPACE);
        result.get(1).add(letter);
    }

    private void addFailMovingResult(String moving) {
        if (moving.equals(UP)) {
            addLetterToFirstFloor(RESULT_FAIL);
            return;
        }
        addLetterToSecondFloor(RESULT_FAIL);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (isRetryEquals(gameCommand)) {
            gameCount++;
            initGame();
            return true;
        }
        return false;
    }

    private boolean isRetryEquals(String command) {
        return command.equals(RETRY);
    }

    private void initGame() {
        movingCount = 0;
        gameEnd = false;
        result.get(0).clear();
        result.get(1).clear();
    }

    public String isSuccess() {
        if (bridge.size() == movingCount) {
            return SUCCESS;
        }
        return FAIL;
    }

    public int getGameCount() {
        return gameCount;
    }

    public boolean isFinishBridge() {
        return bridge.size() == movingCount;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public List<List<String>> getResult() {
        return result;
    }
}
