package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.model.Bridge;
import bridge.utils.InputService;
import bridge.view.OutputView;

public class GameSettingController {
    public Bridge generateBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        OutputView.getOutputView().printBridgeGameStart();
        int bridgeSize = InputService.getInputService().inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
