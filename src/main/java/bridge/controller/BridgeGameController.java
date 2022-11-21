package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveSpace;
import bridge.view.InputView;

public class BridgeGameController {


    public void runGame(){
        Bridge bridge = new Bridge(InputView.readBridgeSize());
        String step = InputView.readMoving();
        BridgeGame.move(bridge, step);
    }

}
