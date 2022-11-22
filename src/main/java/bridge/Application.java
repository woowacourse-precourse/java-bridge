package bridge;

import java.util.List;

import static bridge.BridgeGame.game_status;
import static bridge.GameController.count;
//import static bridge.GameController.round_count;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        int input = gameController.inputView().readBridgeSize();
        if (input == 1) {
            System.out.println("[ERROR]");
            return;
        }
        gameController.set_bridge(input);
        gameController.start();


    }
}

