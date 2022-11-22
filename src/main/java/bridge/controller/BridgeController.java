package bridge.controller;

import bridge.service.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();


    public void start() {
        GameStartMessage();
        GameTest();
    }

    public void GameStartMessage() {
        OutputView.printGameStart();
    }

    public void GameTest() {
        boolean gameRunningCheck = true;
        boolean gameEndCheck = false;
        BridgeGame bridgeGame = createBridgeGame(inputView);
        while (gameRunningCheck) {
            gameRunningCheck = inputMoving(inputView, outputView, bridgeGame);
            if (gameRunningCheck == false) {
                gameRunningCheck = bridgeGame.retry(inputView.readGameCommand());
            }

            if (bridgeGame.endGame()) {
                gameRunningCheck = false;
                gameEndCheck = true;
            }
        }
        outputView.printResult(bridgeGame.currentBridge(),gameEndCheck,bridgeGame.getNumberOfTry());
    }

    }

    private static boolean inputMoving(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (bridgeGame.move(inputView.readMoving())) {
            outputView.printMap(bridgeGame.currentBridge());
            return true;
        }
        outputView.printMap(bridgeGame.currentBridge());
        return false;
    }
}
