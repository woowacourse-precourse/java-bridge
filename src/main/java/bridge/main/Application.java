package bridge.main;

import bridge.controller.BridgeController;
import bridge.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        BridgeController bridgeController = new BridgeController();
        bridgeController.BridgeGameStart();

    }
}
