package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private boolean gameEnd = false;
    private int movingCount = 0;
    private int gameCount = 1;
    private final List<List<String>> result = new ArrayList<>();
    private final static String SUCCESS = "성공";
    private final static String FAIL = "실패";

    public String isSuccess() {
        if (bridge.size() == movingCount) {
            return SUCCESS;
        }
        return FAIL;
    }

    public int getGameCount() {
        return gameCount;
    }

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
        if (bridge.get(movingCount).equals(moving)) {
            movingCount++;
            return;
        }
        gameEnd = true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            gameCount++;
            movingCount = 0;
            gameEnd = false;
            result.get(0).clear();
            result.get(1).clear();
            return true;
        }
        return false;
    }

    public boolean isFinishBridge() {
        return bridge.size() == movingCount;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public List<List<String>> resultBridgeMoving() {
        if (gameEnd) {
            if (bridge.get(movingCount).equals("U")) {
                result.get(0).add("X");
                result.get(1).add(" ");
            } else {
                result.get(0).add(" ");
                result.get(1).add("X");
            }
            return result;
        }

        if (bridge.get(movingCount - 1).equals("U")) {
            result.get(0).add("O");
            result.get(1).add(" ");
        } else {
            result.get(0).add(" ");
            result.get(1).add("O");
        }
        return result;
    }
}
