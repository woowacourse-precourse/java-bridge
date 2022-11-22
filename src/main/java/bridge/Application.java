package bridge;

import bridge.gameplay.GamePlay;

public class Application {

    public static void main(String[] args) {
        GamePlay gamePlay = new GamePlay();
        try {
            gamePlay.play();
        } catch (IllegalArgumentException error) {
            System.out.print(error.getMessage());
        }
    }
}
