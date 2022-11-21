package bridge;

import java.util.List;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final BridgeView bridgeView;

    public BridgeController(BridgeGame bridgeGame, BridgeView bridgeView) {
        this.bridgeGame = bridgeGame;
        this.bridgeView = bridgeView;
    }

    public void start() {
        init();
        loop();
    }

    private void init() {
        bridgeView.gameStartMessage();
        int bridgeSize = bridgeView.inputBridgeSizeMessage();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
    }

    private void loop() {
        while (true) {
            bridgeView.inputMoveCommandMessage();

        }
    }
}
