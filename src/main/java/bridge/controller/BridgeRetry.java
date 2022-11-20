package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.service.Valification;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.controller.GameController.retryOrFinish;

public class BridgeRetry {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final Valification valification = new Valification();

    private String retryOrQuit;

    public void retryBridgeGame(){
        viewRetry();
        checkRetry();
        retryOrFinish();
    }

    private void viewRetry(){
        outputView.printRequestRetry();
        retryOrQuit = inputView.readGameCommand();
        valification.verifyQorR(retryOrQuit);
    }

    private void checkRetry(){
        bridgeGame.retry(retryOrQuit);
    }


}
