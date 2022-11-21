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
            System.out.println(bridgeGame.getBridge());
            do {
                String course = iv.readMoving();
                bridgeGame.move(course);
                map = ov.printMap(bridgeGame.getBridge(), bridgeGame.getMarks());
                if(bridgeGame.isDiscord()) {
                    System.out.println(1);
                    if(bridgeGame.retry(course)) {
                        System.out.println(2);
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
