package bridge.controller;

import static bridge.view.InputView.*;

public class BridgeGameController {
    public static void bridgeGame(){
        int bridgeLen = readBridgeSize();
        bridgeLenRangeCheck(bridgeLen);
        String move = readMoving();
        moveCheck(move);

    }
}
