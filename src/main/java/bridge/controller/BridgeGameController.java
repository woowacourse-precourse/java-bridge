package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.domain.MoveSpace;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    boolean successMoving = true;
    MoveSpace moveSpace;
    MoveResult moveResult;
    public void startGame(){

    }


    public void runGame(){
        Bridge bridge = new Bridge(InputView.readBridgeSize());
        while(successMoving){ // 조건 더 추가해야함
            String step = InputView.readMoving();
            this.successMoving = BridgeGame.move(bridge, step);
            OutputView.printMap();
        }
    }
}
