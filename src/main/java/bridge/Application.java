package bridge;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}