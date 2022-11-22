package bridge;

import java.util.ArrayList;
import java.util.List;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<Direction> bridgeMap;
    private int rowIndex, columnIndex;
    private final List<Direction> track;
    private int tryCount;
    private GameResult gameResult;

    public BridgeGame(List<String> _bridgeMap) {
        setBridgeMap(_bridgeMap);
        rowIndex = 0;
        columnIndex = -1;
        track = new ArrayList<>();
        tryCount = 1;
        gameResult = GameResult.NOTHING_HAPPENED;
    }

    private void setBridgeMap(List<String> _bridgeMap) {
        this.bridgeMap = new ArrayList<>();
        for (String area : _bridgeMap) {
            if (area.equals("U")) {
                this.bridgeMap.add(Direction.UP);
                continue;
            }
            this.bridgeMap.add(Direction.DOWN);
        }
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        move_in_direction(direction);
        if (checkIfUserLose()) {
            gameResult = GameResult.USER_LOSE;
            return;
        }
        if (checkIfUserWin()) {
            gameResult = GameResult.USER_WIN;
            return;
        }
        gameResult = GameResult.NOTHING_HAPPENED;
    }


    public void move_in_direction(Direction direction) {
        track.add(direction);
        if (direction == Direction.UP) {
            moveUp();
        } else if (direction == Direction.DOWN) {
            moveDown();
        }
    }

    private void moveUp() {
        if (rowIndex == 1) {
            rowIndex = 0;
        }
        columnIndex += 1;
    }

    private void moveDown() {
        if (rowIndex == 0) {
            rowIndex = 1;
        }
        columnIndex += 1;
    }

    private boolean checkIfUserLose() {
        Direction whichDirectionIsSafe = bridgeMap.get(columnIndex);
        if (whichDirectionIsSafe == Direction.UP && rowIndex == 1) {
            return true;
        } else if (whichDirectionIsSafe == Direction.DOWN && rowIndex == 0) {
            return true;
        }
        return false;
    }

    private boolean checkIfUserWin() {
        if (columnIndex >= bridgeMap.size() - 1) {
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

    public List<Direction> getBridgeMap() {
        return bridgeMap;
    }

    public List<Direction> getTrack() {
        return track;
    }

    public int getTryCount() {
        return tryCount;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
