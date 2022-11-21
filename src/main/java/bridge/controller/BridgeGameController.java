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
            List<String[]> map;
            bridgeGame.makeBridge(iv.readBridgeSize());
            do {
                bridgeGame.move(iv.readMoving());
                map = ov.printMap(bridgeGame.getBridge(), bridgeGame.getMarks());
                if(bridgeGame.isDiscord()) {
                    if(bridgeGame.retry(iv.readGameCommand())) {
                        bridgeGame.backToFirstSection();
                        continue;
                    }
                    break;
                }
            } while(bridgeGame.isEndOfBridge());
            ov.printResult(map, bridgeGame.getResultOfGame(), bridgeGame.getGameCount());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
