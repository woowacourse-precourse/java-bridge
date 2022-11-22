package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    enum Direction {
        UP, DOWN
    }

    enum Result {
        USER_LOSE, USER_WIN, NOTHING_HAPPENED
    }

    List<String> map;
    int rowIndex, columnIndex;

    public BridgeGame(List<String> map) {
        this.map = map;
        rowIndex = 0;
        columnIndex = -1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public Result play(Direction direction) {
        move(direction);
        if (checkIfUserLose()) {
            return Result.USER_LOSE;
        }
        if (checkIfUserWin()) {
            return Result.USER_WIN;
        }
        return Result.NOTHING_HAPPENED;
    }

    public void move(Direction direction) {
        if (direction == Direction.UP) {
            moveUp();
        } else if (direction == Direction.DOWN) {
            moveDown();
        }
    }

    public void moveUp() {
        if (rowIndex == 1) {
            rowIndex = 0;
        }
        columnIndex += 1;
    }

    public void moveDown() {
        if (rowIndex == 0) {
            rowIndex = 1;
        }
        columnIndex += 1;
    }

    public boolean checkIfUserLose() {
        String whichDirectionIsSafe = map.get(columnIndex);
        if (whichDirectionIsSafe.equals("U") && rowIndex == 1) {
            return true;
        } else if (whichDirectionIsSafe.equals("D") && rowIndex == 0) {
            return true;
        }
        return false;
    }

    public boolean checkIfUserWin() {
        if (columnIndex >= map.size()-1) {
            return true;
        }
        return false;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        rowIndex = 0;
        columnIndex = -1;
    }
}
