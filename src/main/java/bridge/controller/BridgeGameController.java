package bridge.controller;

import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

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
        bridgeGame.makeBridge(iv.readBridgeSize());
        do {
            iv.readMoving;
            move();
            printMap();
            if(불일치 하면) {
                if(재시작) {
                    move()했던 기록 지워
                    continue;
                }
                break;
            }
        } while(끝까지 도달할 때까지)
        최종결과;
    }


}
