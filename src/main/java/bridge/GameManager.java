package bridge;

import bridge.config.Config;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.game.BridgeGame;
import bridge.game.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameManager {

    private final BridgeGame bridgeGame;
    private final GameStatus gameStatus;

    private GameManager(BridgeGame bridgeGame, GameStatus gameStatus) {
        this.bridgeGame = bridgeGame;
        this.gameStatus = gameStatus;
    }

    public static void execute() {
        OutputView.startGame();
        Config config = new Config();
        List<String> bridge = buildBridge(config.bridgeNumberGenerator());
        GameManager gameManager = new GameManager(new BridgeGame(bridge), new GameStatus());
        gameManager.startGame();
    }

    private static List<String> buildBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        OutputView.getBridgeLength();
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void startGame() {
        while (true) {
            GameCommand gameCommand = play(bridgeGame);
            if (gameCommand.isRetry()) {
                retry(bridgeGame, gameStatus);
            }
            if (gameCommand.isFinish()) {
                break;
            }
        }
    }

    private GameCommand play(BridgeGame bridgeGame) {
        try {
            OutputView.selectRoom();
            Direction direction = InputView.readMoving();
            bridgeGame.move(direction);
            gameStatus.move(direction);
            OutputView.printMap(gameStatus.getBridgeStatus());
            if (bridgeGame.isFinish()) {
                OutputView.printResult(gameStatus, direction);
                return GameCommand.FINISH;
            }
        } catch (IllegalArgumentException e) {
            return getUserDecision();
        }

        return GameCommand.PROGRESS;
    }

    private GameCommand getUserDecision() {
        OutputView.checkRestart();
        String input = InputView.readGameCommand();
        GameCommand.checkStatus(input);

        return GameCommand.getStatus(input);
    }

    private void retry(BridgeGame bridgeGame, GameStatus gameStatus) {
        bridgeGame.retry();
        gameStatus.retry();
    }

}
