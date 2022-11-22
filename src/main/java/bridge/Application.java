package bridge;

import bridge.controller.GamePlay;

public class Application {

    private static final GamePlay gamePlay = new GamePlay();

    public static void main(String[] args) {
        try {
            gamePlay.bridgeGameStart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
