package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeNumberGenerator;
import bridge.domain.GameCommand;
import bridge.domain.GameStatus;
import bridge.domain.BridgeMovement;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private GameStatus gameStatus;

    public BridgeController(InputView inputView, OutputView outputView, BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        bridgeGame = new BridgeGame(bridgeNumberGenerator);
        gameStatus = GameStatus.PLAYING;
    }

    public void run() {
        setUp();
        while (gameStatus == GameStatus.PLAYING) {
            playGame();
        }
        end();
    }

    private void setUp() {
        outputView.printGameStart();
        outputView.inputBridgeSize();
        bridgeGame.createBridge(inputView.readBridgeSize());
        outputView.printNewline();
    }

    private void playGame() {
        movePlayer();
        if(gameStatus == GameStatus.FAILED) {
            retryGame();
        }
    }

    private void movePlayer() {
        outputView.inputPlayerMove();
        BridgeMovement playerMove = inputView.readMoving();
        gameStatus = bridgeGame.move(playerMove);
        outputView.printMap(bridgeGame.logResult());
    }

    private void retryGame() {
        outputView.inputPlayerCommand();
        GameCommand command = inputView.readGameCommand();
        gameStatus = bridgeGame.retry(command);
    }

    private void end() {
        outputView.printGameOver();
        outputView.printMap(bridgeGame.logResult());
        outputView.printResult(gameStatus, bridgeGame.getNumberOfAttempts());
    }
}
