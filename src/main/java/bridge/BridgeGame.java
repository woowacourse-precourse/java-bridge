package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> boardList = new ArrayList<>();
    private List<String> upBoardCheckList = new ArrayList<>();
    private List<String> downBoardCheckList = new ArrayList<>();
    private final OutputView outputView;
    private int stage = 0;
    private boolean success = false;
    private int tryCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String board) {
        boolean isRight = false;
        boardList.add(board);
        if (board.equals("U")) {
            isRight = addCheckToUpList(board);
        }
        if (board.equals("D")) {
            isRight = addCheckToDownList(board);
        }
        validate();
        return isRight;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.upBoardCheckList.clear();
        this.downBoardCheckList.clear();
        this.stage = 0;
        this.tryCount += 1;
    }

    private boolean addCheckToUpList(String board) {
        if (bridge.get(stage).equals(board)) {
            upBoardCheckList.add("O");
            downBoardCheckList.add(" ");
            return true;
        }
        upBoardCheckList.add("X");
        downBoardCheckList.add(" ");
        return false;
    }

    private boolean addCheckToDownList(String board) {
        if (bridge.get(stage).equals(board)) {
            downBoardCheckList.add("O");
            upBoardCheckList.add(" ");
            return true;
        }
        downBoardCheckList.add("X");
        upBoardCheckList.add(" ");
        return false;
    }

    private void validate() {
        if (bridge.size() == boardList.size()) {
            if (Arrays.equals(bridge.toArray(), boardList.toArray())) {
                this.success = true;
            }
        }
    }

    public BridgeGame(List<String> bridge, OutputView outputView) {
        this.bridge = bridge;
        this.outputView = outputView;
    }
}
