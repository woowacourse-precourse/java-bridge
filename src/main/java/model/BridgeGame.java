package model;

import dto.GameResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import model.enums.GameStatus;
import model.enums.MoveChoice;
import model.enums.MoveResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<MoveInformation> bridgeMoveInformation;
    private Bridge bridge;
    private int tryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.tryCount = 1;
        this.bridgeMoveInformation = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveChoice) {
        int targetColumn = bridgeMoveInformation.size();
        updateMoveResults(MoveChoice.getMatchChoice(moveChoice), bridge.movable(targetColumn, moveChoice));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        this.bridgeMoveInformation = new ArrayList<>();
    }

    public GameResult getGameResult() {
        return new GameResult(Optional.of(tryCount), Optional.of(getGameStatus()), getBridgeMoveResults());
    }

    public GameResult getSimpleGameResult() {
        return new GameResult(Optional.empty(), Optional.empty(), getBridgeMoveResults());
    }

    public GameStatus getGameStatus() {
        return GameStatus.getMatchStatus(succeed(), failed());
    }

    private boolean succeed() {
        if (failed() || bridge.size() != bridgeMoveInformation.size()) {
            return false;
        }
        return true;
    }

    private boolean failed() {
        int lastIndex = bridgeMoveInformation.size() - 1;
        if (lastIndex < 0) {
            return false;
        }

        return bridgeMoveInformation.get(lastIndex).moveSucceed() != true;
    }

    private void updateMoveResults(MoveChoice moveChoice, boolean succeed) {
        bridgeMoveInformation.add(new MoveInformation(MoveResult.getMatchResult(succeed), moveChoice));
    }

    private List<MoveInformation> getBridgeMoveResults() {
        return Collections.unmodifiableList(bridgeMoveInformation);
    }
}
