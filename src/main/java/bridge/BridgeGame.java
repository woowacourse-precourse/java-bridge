package bridge;

import java.util.ArrayList;
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

    List<Direction> map;
    int rowIndex, columnIndex;
    List<Direction> track;
    int tryCount;

    public BridgeGame(List<String> map) {
        setMap(map);
        rowIndex = 0;
        columnIndex = -1;
        track = new ArrayList<>();
        tryCount = 0;
    }

    private void setMap(List<String> _map) {
        this.map = new ArrayList<>();
        for (String area : _map) {
            if (area == "U") {
                this.map.add(Direction.UP);
                continue;
            }
            this.map.add(Direction.DOWN);
        }
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
        track.add(direction);
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
        Direction whichDirectionIsSafe = map.get(columnIndex);
        if (whichDirectionIsSafe == Direction.UP && rowIndex == 1) {
            return true;
        } else if (whichDirectionIsSafe == Direction.DOWN && rowIndex == 0) {
            return true;
        }
        return false;
    }

    public boolean checkIfUserWin() {
        if (columnIndex >= map.size() - 1) {
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
        tryCount += 1;
    }

    public List<Direction> getMap() {
        return map;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public List<Direction> getTrack() {
        return track;
    }

    public int getTryCount() {
        return tryCount;
    }
}
