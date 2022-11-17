package bridge;

import bridge.config.Config;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {

    private final BridgeGame bridgeGame;
    private final GameStatus gameStatus;

    private GameManager(BridgeGame bridgeGame, GameStatus gameStatus) {
        this.bridgeGame = bridgeGame;
        this.gameStatus = gameStatus;
    }

    public static void execute() {
        Config config = new Config();
        GameManager gameManager = new GameManager(new BridgeGame(config.bridgeNumberGenerator()), new GameStatus());
        gameManager.startGame();
    }

    private void startGame() {
        while (true) {
            GameCommand gameCommand = play(bridgeGame);
            if (gameCommand.isRetry()) {
                retry(bridgeGame, gameStatus);
            }
            if (gameCommand.isFinish()) {
                OutputView.printResult(gameStatus.getBridgeStatus(), gameStatus);
                break;
            }
        }
    }

    private GameCommand play(BridgeGame bridgeGame) {
        try {
            bridgeGame.move(InputView.readMoving());
            if (bridgeGame.isFinish()) {
                return GameCommand.FINISH;
            }
        } catch (IllegalArgumentException e) {
            return getUserDecision();
        }

        return GameCommand.PROGRESS;
    }

    private GameCommand getUserDecision() {
        String input = InputView.readGameCommand();
        GameCommand.checkStatus(input);

        return GameCommand.getStatus(input);
    }

    private void retry(BridgeGame bridgeGame, GameStatus gameStatus) {
        bridgeGame.retry();
        gameStatus.retry();
    }

}
