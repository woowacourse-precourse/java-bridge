package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        try {
            bridgeGame.runGame();
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
