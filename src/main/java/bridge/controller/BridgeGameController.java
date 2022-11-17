package bridge.controller;

import bridge.domain.Bridge;

public class BridgeGameController {
    public static BridgeGame setInstance(int size) {
         return new BridgeGame(size);
    }
}
