package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void play() {
        try {
            outputView.printStartGame();
            setUpBridge(requestBridgeSize());
            requestMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int requestBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBridgeSize();
        }
    }

    private void setUpBridge(int bridgeSize) throws IllegalArgumentException{
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridge(bridge);
    }

    private String requestMoving() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestMoving();
        }
    }
}
