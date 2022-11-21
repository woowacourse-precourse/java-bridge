package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeController bridgeProcess = new BridgeController();
            bridgeProcess.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
