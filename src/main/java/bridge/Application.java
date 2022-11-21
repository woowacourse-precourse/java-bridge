package bridge;

import java.util.List;

public class Application {

    private static final BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame(numberGenerator);
        try {
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
