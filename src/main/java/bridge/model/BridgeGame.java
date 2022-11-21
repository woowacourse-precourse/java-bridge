package bridge.model;

import bridge.model.constant.MoveDirection;
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
    private List<MoveDirection> moveDirections;
    private List<MoveDirection> bridge;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge.stream().map((point) -> MoveDirection.getMatchDirection(point))
                .collect(Collectors.toUnmodifiableList());
        this.tryCount = 1;
        this.moveDirections = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MoveDirection userMoveDirection) {
        moveDirections.add(userMoveDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        this.moveDirections = new ArrayList<>();
    }

    public GameStatus getGameStatus() {
        return new GameStatus(Optional.of(tryCount), gameOver(), getMoveChoices());
    }

    public GameStatus getSimpleGameStatus() {
        return new GameStatus(Optional.empty(), gameOver(), getMoveChoices());
    }

    public boolean inProcess() {
        return !succeed() && !gameOver();
    }

    public boolean succeed() {
        if (gameOver() || bridge.size() != moveDirections.size()) {
            return false;
        }
        return true;
    }

    public boolean gameOver() {
        if (moveDirections.isEmpty()) {
            return false;
        }
        int lastIndex = moveDirections.size() - 1;
        return moveDirections.get(lastIndex) != bridge.get(lastIndex);
    }

    private List<MoveDirection> getMoveChoices() {
        return Collections.unmodifiableList(moveDirections);
    }
}
