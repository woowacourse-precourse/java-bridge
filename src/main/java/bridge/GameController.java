package bridge;

import bridge.Model.BridgeGame;
import bridge.View.InputView;

public class GameController {
    public static void callReadBridgeSize(){
        BridgeGame.size=new InputView().readBridgeSize();
    }

}
