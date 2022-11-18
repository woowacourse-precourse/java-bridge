package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private bridge.domain.BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        BridgeSize bridgeSize = inputBridgeSize();
        BridgeMap bridgeMap = makeBridgeMap(bridgeSize);
    }

    private BridgeSize inputBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBridgeSize();
        }
        return null;
    }

    private BridgeMap makeBridgeMap(BridgeSize bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new BridgeMap(bridgeMaker.makeBridge(bridgeSize.getValue()));
    }
}
