package bridge;

import bridge.controller.BridgeMoveController;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        /*List<String> bridge = new ArrayList<>(List.of("U", "D", "D", "U"));
        BridgeMoveController bridgeMoveController = new BridgeMoveController(bridge);
        bridgeMoveController.run();*/
        new BridgeGame().move();
    }
}
