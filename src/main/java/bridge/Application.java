package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeMaker;


public class Application {


    private static final BridgeMaker bridgeMaker = new BridgeMaker(null);
    private static final String BLANK = " ";
    public static void main(String[] args) {

        BridgeController bridgeController = new BridgeController();
        bridgeController.run();
    }
}
