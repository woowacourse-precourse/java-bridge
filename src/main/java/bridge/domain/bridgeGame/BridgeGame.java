package bridge.domain.bridgeGame;

import bridge.domain.bridgeGame.gameStatus.gameStatics.GameResult;

import java.util.List;
import java.util.Queue;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final GameStatus gameStatus;
    private final Bridge bridge;

    private BridgeGame(GameStatus gameStatus, Bridge bridge) {
        this.gameStatus = gameStatus;
        this.bridge = bridge;
    }

    public static BridgeGame initGame(List<String> bridge) {
        return new BridgeGame(GameStatus.initStatus(), Bridge.from(bridge));
    }

    private void updateGameResult(boolean movingSuccess, boolean isAtEndpoint) {
        if (!movingSuccess) {
            gameStatus.updateGameResult(false);
            return;
        }
        if (isAtEndpoint) {
            gameStatus.updateGameResult(true);
        }
    }

    public Queue<String> getGameStatics() {
        return gameStatus.getGameStatics();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(String direction) {
        int currentDistance = gameStatus.getAndIncreaseDistance();
        String passableDirection = bridge.passableDirectionAt(currentDistance);

        boolean movingSuccess = direction.equals(passableDirection);
        boolean isAtEndpoint = (gameStatus.distance() == bridge.size());
        updateGameResult(movingSuccess, isAtEndpoint);

        return gameStatus.gameResult();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameStatus.retryGame();
        gameStatus.resetDistance();
    }
}
