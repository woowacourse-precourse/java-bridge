package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView  outputView = new OutputView();
    BridgeMaker bridgeMaker;

    public GameController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    private void informStart() {
        outputView.printStartGame();
    }

    private Integer inputBridgeSize() {
        Integer bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    private void buildBridge() {
        Integer bridgeSize = inputBridgeSize();
        List<String> bridgeStrs =  bridgeMaker.makeBridge(bridgeSize);


    }


}
