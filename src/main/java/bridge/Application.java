package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.make_bridge.BridgeMaker;
import bridge.domain.make_bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.OutputViewFormatter;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView(new OutputViewFormatter());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        BridgeGameController bridgeGameController = new BridgeGameController(
                inputView,
                outputView,
                bridgeMaker);

        bridgeGameController.gameStart();
    }
}
