package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeDTO;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameManager {
    private BridgeDTO bridgeDTO;
    OutputView outputView = new OutputView();

    public void runGame() {
        try {
            makeBridgeGame();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void makeBridgeGame() {
        InputView inputView = new InputView();
        outputView.printStartGame();
        outputView.printMakeBridgeSize();
        this.bridgeDTO = inputView.makeBridgeData();
    }
}
