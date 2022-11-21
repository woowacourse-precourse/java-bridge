package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.Domain.BridgeNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

public class BridgeController {
    static int count_try;

    public BridgeController() {
        OutputView.printStart();
        count_try = 1;
    }
    public void run(){
        BridgeGame game = new_BridgeGame();
    }

    private BridgeGame new_BridgeGame(){
        return new BridgeGame(InputView.readBridgeSize());
    }
}
