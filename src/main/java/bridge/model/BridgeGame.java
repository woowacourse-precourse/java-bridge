package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int userLocation;
    private GameState gameState;
    private GameResultBoard gameResultBoard;

    public BridgeGame(List<String> bridge) {
        this.userLocation = 0;
        this.bridge = bridge;
        this.gameState = GameState.NOT_FINISH;
        this.gameResultBoard = new GameResultBoard();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public GameState getGameState() {
        return gameState;
    }

    public GameResultBoard getGameResultBoard() {
        return gameResultBoard;
    }

    public String currentBridge() {
        return bridge.get(userLocation - 1);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (gameState.equals(GameState.NOT_FINISH))
            userLocation++;
        changeState(direction);
    }

    private void changeState(String direction) {
        if (!bridge.get(userLocation - 1).equals(direction)) {
            gameState = GameState.FINISH_FAIL;
            return;
        }
        finishGame();
    }

    private void finishGame() {
        if (this.userLocation >= this.bridge.size())
            gameState = GameState.FINISH_SUCCESS;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
