package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private int attempts;
    private GameState gameState;

    public BridgeGame(List<String> bridge) {
        this.bridge = new Bridge(bridge);
        this.gameState = GameState.NOT_FINISH;
        this.attempts = 1;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getAttempts() {
        return attempts;
    }

    public List<List<String>> getBridge() {
        return this.bridge.getBridge();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (gameState.equals(GameState.NOT_FINISH))
            bridge.move();
        changeState(direction);
        bridge.update(direction);
    }

    private void changeState(String direction) {
        if (!bridge.canMove(direction)) {
            gameState = GameState.FINISH_FAIL;
            return;
        }
        if (bridge.arrived())
            gameState = GameState.FINISH_SUCCESS;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        if (command.equals("R")) {
            gameState = GameState.NOT_FINISH;
            bridge.init();
            attempts++;
        }
    }

    public void update(String direction) {
        bridge.update(direction);
    }
}
