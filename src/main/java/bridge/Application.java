package bridge;

import bridge.cotroller.BridgeGame;
import bridge.cotroller.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
       InputView inputView = new InputView();
       OutputView outputView = new OutputView();
       BridgeGame bridgeGame = new BridgeGame();
    }
}
