package bridge;

import bridge.controller.BridgeController;
import bridge.controller.BridgeGame;
import bridge.enums.Message;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeController bridgeController = new BridgeController();
            bridgeController.start();
        } catch (Exception error) {
            System.out.println("[ERROR] : " + error);
        }
    }
}
