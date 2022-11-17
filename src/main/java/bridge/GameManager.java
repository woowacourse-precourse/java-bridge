package bridge;

import bridge.config.Config;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.exception.ErrorMessage;
import bridge.exception.FailException;
import bridge.exception.InvalidInputException;
import bridge.game.BridgeGame;
import bridge.game.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameManager {

    private final BridgeGame bridgeGame;

    private GameManager(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public static void execute() {
        OutputView.startGame();

        Config config = new Config();
        List<String> bridge = buildBridge(config.bridgeNumberGenerator());
        GameManager gameManager = new GameManager(new BridgeGame(bridge, new GameStatus()));

        gameManager.startGame();
    }

    private static List<String> buildBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        OutputView.getBridgeLength();

        int bridgeSize = getBridgeLength();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static int getBridgeLength() {
        while (true) {
            try {
                return InputView.readBridgeSize();
            } catch (NumberFormatException e) {
                OutputView.printErrorMessage(ErrorMessage.BRIDGE_LENGTH_IS_BETWEEN_3_AND_20);
            }
        }
    }

    private void startGame() {
        while (true) {
            GameCommand gameCommand = play();
            if (gameCommand.isFinish()) {
                break;
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
            OutputView.printErrorMessage(e.getMessage());
            return GameCommand.PROGRESS;
        } catch (FailException e) {
            return getUserDecision();
        }
    }

    private GameCommand move() {
        OutputView.selectRoom();
        Direction direction = InputView.readMoving();
        bridgeGame.move(direction);
        OutputView.printMap(bridgeGame.getMap());

        if (bridgeGame.isFinish()) {
            OutputView.printResult(bridgeGame.getStatus(), direction);
            return GameCommand.FINISH;
        }
        return GameCommand.PROGRESS;
    }

    private GameCommand getUserDecision() {
        OutputView.checkRestart();
        String input = InputView.readGameCommand();
        GameCommand.checkStatus(input);

        return GameCommand.getStatus(input);
    }

}
