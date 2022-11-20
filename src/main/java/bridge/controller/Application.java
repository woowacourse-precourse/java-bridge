package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        do {
            playGame(inputView, outputView, bridgeGame);
            if (bridgeGame.isGameFailed()) {
                String gameCommand = inputView.readGameCommand();
                bridgeGame.retry(gameCommand);
            }
        } while (!bridgeGame.isGameEnd());
        outputView.printResult(bridgeGame);
    }

    private static void playGame(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        do {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
            outputView.printMap(bridgeGame);
        } while (!bridgeGame.isGameEnd());
    }
}
