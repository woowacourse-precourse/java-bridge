package bridge;

import bridge.ui.InputView;
import bridge.ui.OutputView;

public class GameManager {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void bridge(){
        outputView.printBridgeGameStart();

        int bridgeSize = inputView.readBridgeSize();
    }

}
