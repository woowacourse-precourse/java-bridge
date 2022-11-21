package bridge.main;

import bridge.controller.BridgeController;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        BridgeController bridgeController = new BridgeController();
        bridgeController.startGame();

    }
}
