package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeService bridgeService = new BridgeService();
    private boolean gameRunningCheck = true;
    private boolean gameEndCheck = false;
    private BridgeGame bridgeGame;


    public void start() {
        GameStartMessage();
        GameTest();
    }

    public void start() {
        OutputView.printGameStart();
        bridgeGame = bridgeService.bridgeMaker(inputView);
        playBridgeGame();
        outputView.printResult(bridgeGame.currentBridge(), gameEndCheck, bridgeGame.getNumberOfTry());

    }

    public void playBridgeGame() {
        while (gameRunningCheck) {
            gameRunningCheck = inputMoving(inputView, outputView, bridgeGame);
            isGameRunningCheck();
            isGameEndCheck();
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


    public boolean isGameRunningCheck() {
        if (!gameRunningCheck) {
            gameRunningCheck = bridgeGame.retry(inputView.readGameCommand());
        }
        return gameRunningCheck;
    }

    public boolean isGameEndCheck() {
        if (bridgeGame.endGame()) {
            gameRunningCheck = false;
            gameEndCheck = true;
        }
        return gameRunningCheck;
    }


}
