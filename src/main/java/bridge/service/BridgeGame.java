package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private final List<String> boardList = new ArrayList<>();
    private final List<String> upBoardList = new ArrayList<>();
    private final List<String> downBoardList = new ArrayList<>();
    private int stage = 0;
    private int tryCount = 1;
    private boolean success = false;
    private boolean moveSuccess = true;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String move) {
        boardList.add(move);
        if (move.equals("U")) {
            addUpList(move);
        }
        if (move.equals("D")) {
            addDownList(move);
        }
        stage += 1;
        ValidateBrideSizeSameAsBoardList();
        return moveSuccess;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.boardList.clear();
        this.upBoardList.clear();
        this.downBoardList.clear();
        this.stage = 0;
        this.tryCount += 1;
        this.moveSuccess = true;
    }

    private void addUpList(String move) {
        if (bridge.get(stage).equals(move)) {
            upBoardList.add("O");
            downBoardList.add(" ");
            moveSuccess = true;
            return;
        }
        upBoardList.add("X");
        downBoardList.add(" ");
        moveSuccess = false;
    }

    private void addDownList(String move) {
        if (bridge.get(stage).equals(move)) {
            downBoardList.add("O");
            upBoardList.add(" ");
            moveSuccess = true;
            return;
        }
        downBoardList.add("X");
        upBoardList.add(" ");
        moveSuccess = false;
    }

    private void ValidateBrideSizeSameAsBoardList() {
        if (bridge.size() == boardList.size()) {
            if (Arrays.equals(bridge.toArray(), boardList.toArray())) {
                this.success = true;
            }
        }
    }

    public List<String> getUpBoardList() {
        return upBoardList;
    }

    public List<String> getDownBoardList() {
        return downBoardList;
    }

    public boolean getSuccess() {
        return success;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean getMoveSuccess() {
        return moveSuccess;
    }
}
