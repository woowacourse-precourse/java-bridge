package bridge.model;

import bridge.model.enums.MoveChoice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;
    private List<MoveChoice> moveChoices;
    private List<MoveChoice> bridge;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge.stream().map((point) -> MoveChoice.getMatchChoice(point))
                .collect(Collectors.toUnmodifiableList());
        this.tryCount = 1;
        this.moveChoices = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movingType) {
        MoveChoice choice = MoveChoice.getMatchChoice(movingType);

        int targetColumn = moveChoices.size();
        updateMoveResults(movable(targetColumn, choice), choice);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        this.moveChoices = new ArrayList<>();
    }

    public GameResult getGameResult() {
        return new GameResult(Optional.of(tryCount), succeed(), getMoveChoices());
    }

    public GameResult getSimpleGameResult() {
        return new GameResult(Optional.empty(), succeed(), getMoveChoices());
    }

    public boolean inProcess() {
        return !succeed() && !gameOver();
    }

    public boolean succeed() {
        if (gameOver() || bridge.size() != moveChoices.size()) {
            return false;
        }
        return true;
    }

    public boolean gameOver() {
        if (moveChoices.isEmpty()) {
            return false;
        }
        int lastIndex = moveChoices.size() - 1;
        return moveChoices.get(lastIndex) != bridge.get(lastIndex);
    }

    private void updateMoveResults(boolean succeed, MoveChoice moveChoice) {
        moveChoices.add(moveChoice);
    }

    private List<MoveChoice> getMoveChoices() {
        return Collections.unmodifiableList(moveChoices);
    }

    private boolean movable(int position, MoveChoice moveChoice) {
        return this.bridge.get(position) == moveChoice;
    }
}
