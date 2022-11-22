package bridge.model;

import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private int tryNumber;
    private GameResult gameResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tryNumber = 1;
        gameResult = new GameResult();
    }

    public GameResult move(int round, String command) {
        gameResult.add(bridge.get(round).equals(command));
        return gameResult;
    }

    public void retry() {
        tryNumber += 1;
        this.gameResult = new GameResult();
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
