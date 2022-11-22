package bridge.controller;

import static bridge.domain.Bridge.runMoving;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.domain.MoveSpace;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    public  void playGame(){
        Bridge bridge = startGame();
        runGame(bridge);
    }
    public Bridge startGame() {
        Bridge bridge = new Bridge(InputView.readBridgeSize());
        return bridge;
    }


    public static void runGame(Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame();

        if (runMoving(bridgeGame, bridge)){
            bridgeGame.retry(bridge);
        }
    }



}
