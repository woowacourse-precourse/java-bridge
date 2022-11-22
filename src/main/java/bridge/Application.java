package bridge;

import bridge.controller.BridgeGameController;

public class Application {
    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.startGame(false);   // 하드코딩 수정하기
    }
}
