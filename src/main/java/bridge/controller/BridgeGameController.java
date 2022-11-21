package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeLength;
import bridge.model.BridgeMoving;
import bridge.model.BridgeRetry;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;


    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void go(){
        try {
            int size = start();
            do {
                play();
                outputView.printMap(bridgeGame.getUpBridge(),bridgeGame.getDownBridge(),bridgeGame.getLocation());
            } while (retryGame(size) && !bridgeGame.checkEndPoint());
            end();
        }catch (Exception e){
            outputView.printException(e.getMessage());
        }
    }

    private int start() {
        outputView.printInit();
        String size = inputView.readBridgeSize();
        BridgeLength bridgeLength = BridgeLength.createBridgeLength(size);
        bridgeGame = BridgeGame.createBridgeGame(bridgeLength.getLength());
        return bridgeLength.getLength();
    }

    private void play() {
        String moving = inputView.readMoving();
        BridgeMoving bridgeMoving = BridgeMoving.createBridgeMoving(moving);
        bridgeGame.move(moving);
    }

    private boolean retryGame(int size) {
        boolean retry=true;
        if(bridgeGame.isClosed()) {
            String retryOrClose = inputView.readGameCommand();
            BridgeRetry bridgeRetry = BridgeRetry.createBridgeRetry(retryOrClose);
            retry = isRetryOrClose(size, retryOrClose);
        }
        return retry;
    }

    private boolean isRetryOrClose(int size, String retryOrClose) {
        BridgeRetry bridgeRetry =  BridgeRetry.createBridgeRetry(retryOrClose);
        if (bridgeRetry.isRetry()) {
            bridgeGame.retry(size);
            return true;
        }
        return false;
    }

    private void end() {
        outputView.printFinalMap(bridgeGame.getUpBridge(),bridgeGame.getDownBridge(), bridgeGame.getLocation());
        outputView.printResult(bridgeGame.getRetryCount(), !bridgeGame.isClosed());
    }
}
