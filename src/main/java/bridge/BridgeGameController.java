package bridge;

import java.util.List;

public class BridgeGameController {
    private static int count = 0;
    private final InputView inputView;
    private List<String> bridge;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public BridgeGameController() {
        inputView = new InputView();
    }

    public void run() {
        prepareBridgeGame();
        startBridgeGame();
    }

    private void prepareBridgeGame() {
        OutputView.printStartBridgeGame();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void startBridgeGame() {
        while(true) {
            String inputStatus = inputView.readMoving();
            if (BridgeGame.move(inputStatus, bridge, count++)) {break;}
        }
    }


}
