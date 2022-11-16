package bridge.Controller;

import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameController {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public GameController() {

    }

    public GameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void run() {

    }
}
