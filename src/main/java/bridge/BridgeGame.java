package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static List<String> POSSIBLE_DIRECTION = List.of("U", "D");
    private List<String> bridge;
    private List<String> userPath;
    private GameStatus gameStatus;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.userPath = new ArrayList<>();
        this.gameStatus = GameStatus.ONGOING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        validateMove(direction);
        userPath.add(direction);
    private boolean isLastMoveCorrect() {
        int lastMoveIndex = userPath.size() - 1;
        if (lastMoveIndex == -1) {
            return true;
        }
        return bridge.get(lastMoveIndex).equals(
                userPath.get(lastMoveIndex)
        );
    }

    private void updateGameStatus() {
        if (bridge.equals(userPath)) {
            gameStatus = GameStatus.WIN;
        }
        if (bridge.size() == userPath.size()) {
            gameStatus = GameStatus.LOSE;
        }
        if (!isLastMoveCorrect()) {
            gameStatus = GameStatus.LOSE;
        }
    }

    private void validateMove(String direction) {
        if (!POSSIBLE_DIRECTION.contains(direction)) {
            throw new IllegalArgumentException("[ERROR] 아래 칸 'D' 혹은 위 칸 'U' 으로만 이동할 수 있습니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
