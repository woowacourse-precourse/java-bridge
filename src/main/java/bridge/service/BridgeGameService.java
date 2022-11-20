package bridge.service;

import bridge.domain.Command;
import bridge.domain.bridge.BridgeUnit;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameStatus;

import static bridge.domain.Command.RETRY;

public class BridgeGameService {

    public GameStatus crossBridgeUnit(BridgeGame bridgeGame, String moving) {
        BridgeUnit nextUnit = BridgeUnit.from(moving);
        return bridgeGame.move(nextUnit);
    }

    public GameStatus readGameCommand(BridgeGame bridgeGame, GameStatus status, String code) {
        Command command = Command.from(code);
        return invokeIfRetry(bridgeGame, command, status);
    }

    private GameStatus invokeIfRetry(BridgeGame bridgeGame, Command command, GameStatus status) {
        if (RETRY.equals(command)) {
            return bridgeGame.retry();
        }
        return status;
    }
}
