package bridge;

import bridge.domain.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController gameController = new BridgeGameController();
        gameController.start();
    }
}
