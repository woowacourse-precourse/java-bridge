package Controller;

import bridge.*;

import java.util.List;

public class BridgeController {
    private InputView inputView = new InputView();
    private OutputView outView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private BridgeGame bridgeGame;
    private final int bridgeSize;
    private final List<String> bridge;


    public BridgeController() {
        outView.printStartGame();
        System.out.println();

        this.bridgeSize = inputView.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.bridgeGame = new BridgeGame(bridge);
    }

}


