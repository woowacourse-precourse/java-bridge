package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        printGameStartMessage();
        BridgeGameController bridgeGameController = new BridgeGameController();
        try {
            bridgeGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println(" ");
    }
}
