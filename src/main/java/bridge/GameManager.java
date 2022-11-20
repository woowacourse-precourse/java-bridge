package bridge;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class GameManager {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void bridge(){
        outputView.printBridgeGameStart();
        List<String> bridge = createBridge();

        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.start();


    }

    private static List<String> createBridge(){
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

}
