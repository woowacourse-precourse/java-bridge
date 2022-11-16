package bridge.controller;

import bridge.dto.BridgeSizeDTO;
import bridge.view.InputView;

public class BridgeGameController {
    public void start() {
        final InputView inputView = new InputView();
        final BridgeSizeDTO bridgeSizeDTO = inputView.readBridgeSize();
    }
}
