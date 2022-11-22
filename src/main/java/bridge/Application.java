package bridge;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.controller.BridgeGameController;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        BridgeGameController bgc = new BridgeGameController();
        bgc.run();
    }
}
