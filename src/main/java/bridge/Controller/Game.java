package bridge.Controller;

import bridge.Model.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Game {

    public void run() {
        OutputView.printInit();
        makeBridge();
    }

    private void makeBridge() {
        BridgeGame.saveBridgeSize(InputView.readBridgeSize());
    }

}
