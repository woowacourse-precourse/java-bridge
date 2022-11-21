package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;

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
        outputView.printResult();
        System.out.println(outputView.printMap(bridgeGame.currentBridge()));
        System.out.println(outputView.printSuccessCheck(gameEndCheck));

        outputView.printGameTotalTry(bridgeGame.getNumberOfTry());
    }

    private static BridgeGame createBridgeGame(InputView inputView) {
        return new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(inputView.readBridgeSize()));
    }

    private static boolean inputMoving(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (bridgeGame.move(inputView.readMoving())) {
            System.out.println(outputView.printMap(bridgeGame.currentBridge()));
            return true;
        }
        System.out.println(outputView.printMap(bridgeGame.currentBridge()));
        return false;
    }
}
