package bridge;

import bridge.config.Config;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.exception.FailException;
import bridge.exception.InvalidInputException;
import bridge.game.BridgeGame;
import bridge.game.GameStatus;
import bridge.view.View;
import java.util.List;

public class GameManager {

    private final BridgeGame bridgeGame;

    private GameManager(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public static void execute() {
        View.startGame();

        Config config = new Config();
        List<String> bridge = buildBridge(config.bridgeNumberGenerator());
        GameManager gameManager = new GameManager(new BridgeGame(bridge, new GameStatus()));

        gameManager.startGame();
    }

    private static List<String> buildBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        int bridgeSize = View.getBridgeLength();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void startGame() {
        while (true) {
            GameCommand gameCommand = play();
            if (gameCommand.isFinish()) {
                return;
            }
            if (gameCommand.isRetry()) {
                bridgeGame.restart();
            }
        }
    }

    private GameCommand play() {
        try {
            return move();
        } catch (InvalidInputException e) {
            View.printErrorMessage(e.getMessage());
            return GameCommand.PROGRESS;
        } catch (FailException e) {
            return getUserDecision();
        }
    }

    private GameCommand move() {
        Direction direction = View.readMoving();
        bridgeGame.move(direction);
        View.printMap(bridgeGame.getMap());

        if (bridgeGame.isFinish()) {
            View.printResult(bridgeGame.getStatus(), direction);
            return GameCommand.FINISH;
        }
        return GameCommand.PROGRESS;
    }

    private GameCommand getUserDecision() {
        String input = View.checkRestart();
        GameCommand.checkStatus(input);

        return GameCommand.getStatus(input);
    }

}
