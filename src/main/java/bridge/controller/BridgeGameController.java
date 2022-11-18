package bridge.controller;

import static bridge.view.InputView.readBridgeSize;
import static bridge.view.InputView.readMoving;

public class BridgeGameController {
    public static void bridgeGame(){
        int bridgeLen = readBridgeSize();
        String move = readMoving();
    }
}
