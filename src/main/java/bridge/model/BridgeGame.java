package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int userLocation;
    private final List<String> bridge;
    private GameState gameState;

    public BridgeGame(List<String> bridge) {
        this.userLocation = 0;
        this.bridge = bridge;
        this.gameState = GameState.NOT_FINISH;
    }

    public int getUserLocation() {
        return userLocation;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public GameState getGameState() {
        return gameState;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (! bridge.get(userLocation).equals(direction))
            gameState = GameState.FINISH_FAIL;

        if (gameState.equals(GameState.NOT_FINISH))
            userLocation++;
        finishGame();
    }

    private void finishGame(){
        if (this.userLocation == this.bridge.size())
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
