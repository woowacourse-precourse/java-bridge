package model;

import dto.GameResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import model.enums.GameStatus;
import model.enums.MoveChoice;
import model.enums.MoveResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<List<MoveResult>> moveResults;
    private Bridge bridge;
    private int tryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.tryCount = 1;
        this.moveResults = List.of(new ArrayList<MoveResult>().stream().limit(2).collect(Collectors.toList()));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveChoice) {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public GameResult getFinalGameResult() {
    }

    public GameResult getGameResult() {
        return null;
    }

    public GameStatus getGameStatus() {
        return null;
    }

    private boolean succeed() {
        return false;
    }

    private boolean failed() {
        return false;
    }

    private void updateMoveResults(int row, boolean succeed) {
    }
}
