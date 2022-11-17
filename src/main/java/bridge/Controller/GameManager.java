package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeDTO;
import bridge.View.InputView;

public class GameManager {
    private BridgeDTO bridgeDTO;

    public void runGame() {
        makeBridgeGame();
    }

    public void makeBridgeGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        InputView inputView = new InputView();
        bridgeDTO.getBridge();
    }
}
