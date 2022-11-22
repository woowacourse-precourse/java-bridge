package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void gameStart() {
        outputView.printGameStart();
        BridgeGame bridgeGame = makeBridgeGame();
        do {
            playGame(bridgeGame);
            checkWhetherGameRetry(bridgeGame);
        } while (!bridgeGame.isGameEnd());
        outputView.printResult(bridgeGame);
    }

    private BridgeGame makeBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeGame(bridgeSize);
    }

    private void checkWhetherGameRetry(BridgeGame bridgeGame) {
        if (bridgeGame.isGameFailed()) {
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);
        }
    }

    private void playGame(BridgeGame bridgeGame) {
        do {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame);
        } while (!bridgeGame.isGameEnd());
    }
}
