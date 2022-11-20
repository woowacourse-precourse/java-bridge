package model;

import static model.enums.MoveChoice.getPositionNumber;
import static model.enums.MoveResult.FAIL;
import static model.enums.MoveResult.NULL;
import static model.enums.MoveResult.getMatchResult;

import dto.GameResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.enums.GameStatus;
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
        this.moveResults = List.of(new ArrayList<>(), new ArrayList<>());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveChoice) {
        int targetIndex = moveResults.get(0).size();
        updateMoveResults(getPositionNumber(moveChoice), bridge.movable(targetIndex, moveChoice));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        this.moveResults = List.of(new ArrayList<>(), new ArrayList<>());
    }

    public GameResult getFinalGameResult() {
        return new GameResult(Optional.of(tryCount), Optional.of(getGameStatus()), getMoveResults());
    }

    public GameResult getGameResult() {
        return new GameResult(Optional.empty(), Optional.empty(), getMoveResults());
    }

    public GameStatus getGameStatus() {
        return GameStatus.getMatchStatus(succeed(), failed());
    }

    private boolean succeed() {
        if (failed() || bridge.size() != moveResults.get(0).size()) {
            return false;
        }
        return true;
    }

    private boolean failed() {
        int lastIndex = moveResults.get(0).size() - 1;
        if (lastIndex < 0) {
            return false;
        }

        return IntStream.range(0, moveResults.size()).anyMatch((i) -> moveResults.get(i).get(lastIndex).equals(FAIL));
    }

    private void updateMoveResults(int row, boolean succeed) {
        for (int i = 0; i < moveResults.size(); i++) {
            List<MoveResult> rowMoveResult = moveResults.get(i);
            if (i == row) {
                rowMoveResult.add(getMatchResult(succeed));
                continue;
            }
            rowMoveResult.add(NULL);
        }
    }

    private List<List<MoveResult>> getMoveResults() {
        return moveResults.stream().map((rowMoveResults) -> Collections.unmodifiableList(rowMoveResults))
                .collect(Collectors.toUnmodifiableList());
    }
}
