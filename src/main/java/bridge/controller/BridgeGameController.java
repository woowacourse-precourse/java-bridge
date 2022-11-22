package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void start() {
        outputView.printStart();
        createAnswerBridge();

        do {
            playGame();
        } while (bridgeGame.isContinue());

        resultGame();
    }

    private void createAnswerBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridgeGame.setAnswerBridge(bridge);
    }

    private void playGame() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getBridgePrintMaker());
        checkRetry();
    }

    private void resultGame() {
        outputView.printResult(bridgeGame);
    }

    private void checkRetry() {
        if (bridgeGame.isFail()) {
            bridgeGame.updateRestart(inputView.readGameCommand());
        }
    }
}
