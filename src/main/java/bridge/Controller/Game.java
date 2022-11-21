package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Game {

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        OutputView.printInit();
        makeBridge();
    }

    private void makeBridge() {
        BridgeGame.saveBridgeSize(InputView.readBridgeSize());
        bridgeMaker.makeBridge(BridgeGame.getBridgeSize());
    }
}
