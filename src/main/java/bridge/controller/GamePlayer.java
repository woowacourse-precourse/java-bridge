package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeMaker;
import bridge.model.BridgeStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> bridge = new ArrayList<>();
    private final BridgeGame bridgeGame = new BridgeGame();
    private BridgeStatus bridgeStatus = new BridgeStatus();
    public void play() {
        this.bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        this.bridgeGame.setBridge(bridge);
        System.out.println(this.bridge);
        bridgeStatus.initBridgeStatus();
        crossingBridge();
    }
    private void crossingBridge() {
        boolean successFlag = true;
        for(String space: this.bridge) {
            successFlag = this.bridgeGame.move(inputView.readMoving(), space);
            outputView.printMap(bridgeStatus.getUpBridgeStatus(), bridgeStatus.getDownBridgeStatus());
            if(!successFlag) {
                break;
            }
        }
        retryOrExit(successFlag);
    }
    private void retryOrExit(boolean success) {
        if(success) outputView.printResult();
        bridgeGame.retry(inputView.readGameCommand());
    }
}
