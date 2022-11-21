package bridge.controller;

import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    BridgeGame bridgeGame;

    InputView iv;
    OutputView ov;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame();
        this.iv = new InputView();
        this.ov = new OutputView();
    }

    public void run() {
        try{
            makeBride();
            gamePlay();
            printResult();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void makeBride() {
        bridgeGame.makeBridge(iv.readBridgeSize());
    }
    private void gamePlay() {
        do {
            bridgeGame.move(iv.readMoving());
            bridgeGame.setMap(ov.printMap(bridgeGame.getBridge(), bridgeGame.getMarks()));
            if(bridgeGame.isDiscord()) {
                if(!bridgeGame.retry(iv.readGameCommand())) break;
                bridgeGame.backToFirstSection();
            }
        } while(bridgeGame.isEndOfBridge());
    }
    private void printResult() {
        ov.printResult(bridgeGame.getMap(), bridgeGame.getResultOfGame(), bridgeGame.getGameCount());
    }
}
