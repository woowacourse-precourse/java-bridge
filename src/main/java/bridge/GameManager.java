package bridge;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class GameManager {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void bridge(){
        outputView.printBridgeGameStart();

        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        for (String s : bridge) {
            System.out.print(s);
        }
        System.out.println();

    }

}
