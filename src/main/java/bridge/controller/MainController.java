package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.view.InputView;

public class MainController {
    public static void run() {
        BridgeSize bridgeSize = new BridgeSize(InputView.readBridgeSize());
    }
}
