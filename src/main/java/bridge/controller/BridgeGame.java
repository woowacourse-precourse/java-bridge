package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.domain.PositionTable;
import bridge.domain.TryNumber;
import java.util.stream.Stream;

public class BridgeGame {
    private Bridge bridge;
    private PositionTable userTable;
    private TryNumber tryNumber = TryNumber.zero();

    private BridgeGame(Bridge bridge, PositionTable userTable) {
        this.bridge = bridge;
        this.userTable = userTable;
    }
    public static BridgeGame of(Bridge bridge, PositionTable userTable) {
        return new BridgeGame(bridge, userTable);
    }

    public GameResult determineRetry(GameResult gameResult) throws IllegalArgumentException {
        if (gameResult.isLose()) {
            gameResult = GameResult.retryOrNot(BridgeGameManager.readGameCommand());
        }
        return gameResult;
    }

    public GameResult move() throws IllegalArgumentException, IllegalStateException {
        return Stream.iterate(0,i->i<bridge.size(),i->i+1)
                .map(i-> BridgeGameManager.moveUser(userTable, bridge))
                .filter(GameResult::isNotKeep)
                .findFirst()
                .orElse(GameResult.KEEP);
    }
    public int getTryNumber() {
        return tryNumber.getTryNumber();
    }
    public GameResult retry(GameResult gameResult) throws IllegalArgumentException, IllegalStateException {
        while (gameResult.isKeep()) {
            userTable.clear();
            gameResult = startGame();
        }
        return gameResult;
    }

    public GameResult startGame() throws IllegalArgumentException, IllegalStateException {
        tryNumber.increase();
        GameResult gameResult = move();
        return determineRetry(gameResult);
    }
}
