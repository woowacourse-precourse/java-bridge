package bridge.main;

import bridge.controller.BridgeController;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        try {
            BridgeController bridgeController = new BridgeController();
            bridgeController.startGame();
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println("ERROR");
        }
    }
}
