package bridge;

import bridge.Model.BridgeGame;
import bridge.View.InputView;

public class GameController {
    public static void callReadBridgeSize(){
        BridgeGame.size=new InputView().readBridgeSize();
        startBridgeMaker();
    }

    public static void startBridgeMaker(){
        new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(BridgeGame.size);
    }

}
