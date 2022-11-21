package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.domain.MoveSpace;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    boolean successMoving = true;
    public void startGame(){

    }


    public void runGame(){
        BridgeGame bridgeGame = new BridgeGame();
        Bridge bridge = new Bridge(InputView.readBridgeSize());
        List<MoveResult> moveResult = new ArrayList<>();
        bridgeGame.move(moveResult, bridge);
        OutputView.printMap(moveResult);
    }
}
