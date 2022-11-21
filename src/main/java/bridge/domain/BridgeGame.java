package bridge.domain;

public class BridgeGame {
    private final Bridge bridge;
    private final GameState gameState;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameState = new GameState();
        gameState.init();
    }

    public GameState move(String move) {
        if (!bridge.isMovable(move, gameState.nextLocation())) {
            return gameState.updateState(move, BridgeState.FALL);
        }
        if (bridge.size() - 1 == gameState.nextLocation()) {
            return gameState.updateState(move, BridgeState.CROSSED);
        }
        return gameState.updateState(move, BridgeState.CROSSING);
    }

    public void retry() {
        gameState.init();
    }
}
