package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.printStartBridgeGame();
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
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> test = bridgeMaker.makeBridge(bridgeSize.getValue());
        return new BridgeMap(test);
    }
}
