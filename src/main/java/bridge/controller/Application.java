package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static InputView inputView;
    private static OutputView outputView;

    public static void main(String[] args) {
        viewInitialize();
        BridgeGame bridgeGame = makeBridgeGame();
        do {
            playGame(bridgeGame);
            checkWhetherGameRetry(bridgeGame);
        } while (!bridgeGame.isGameEnd());
        outputView.printResult(bridgeGame);
    }

    private static void viewInitialize() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    private static BridgeGame makeBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeGame(bridgeSize);
    }

    private static void checkWhetherGameRetry(BridgeGame bridgeGame) {
        if (bridgeGame.isGameFailed()) {
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);
        }
    }

    private static void playGame(BridgeGame bridgeGame) {
        do {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame);
        } while (!bridgeGame.isGameEnd());
    }
}
