package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Game;
import bridge.model.BridgeMaker;
import bridge.model.BridgeStatus;
import bridge.model.GameRetry;
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
    private GameRetry gameRetry = new GameRetry();
    public void play() {
        this.bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        this.bridgeGame.setBridge(bridge);
        bridgeStatus.initBridgeStatus();
        crossingBridge();
    }
    private void crossingBridge() {
        boolean failFlag = true;
        for(String space: this.bridge) {
            failFlag = this.bridgeGame.move(inputView.readMoving(), space);
            outputView.printMap(bridgeStatus.getUpBridgeStatus(), bridgeStatus.getDownBridgeStatus());
            if(!failFlag) {
                break;
            }
        }
        retryOrExit(failFlag);
    }

    private void retryOrExit(boolean fail) {
        if(fail) //성공
        gameRetry.retryOrQuit(inputView.readGameCommand());
    }
}
