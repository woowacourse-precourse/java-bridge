package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.InputController;
import bridge.model.Record;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;

public class Application {

    public static void main(String[] args) {
        InputController inputController = new InputController(new InputView(), new OutputView());
        BridgeGameController bridgeGameController = new BridgeGameController();
        OutputView outputView = new OutputView();

        outputView.printGameStart();
        bridgeGameController.start(inputController.getBridgeSize(),
                new Record(new ArrayList<>(),new HashMap<>()));
    }
}
