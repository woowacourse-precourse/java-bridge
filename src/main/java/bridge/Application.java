package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameManager game = new BridgeGameManager();
            game.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
