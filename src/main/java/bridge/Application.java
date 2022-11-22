package bridge;

import bridge.controller.BridgeGameController;
import bridge.util.Log;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            BridgeGameController gameController = new BridgeGameController();
            gameController.run();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
        }
    }
}
