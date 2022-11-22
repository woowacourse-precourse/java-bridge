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
        // System.out.print(bridge.toString());
        gameController.set_bridge(input);
        while (BridgeGame.game_status.equals("playing") && gameController.Bridge().size() != count) {
            String position = gameController.inputView().readMoving();
            if (gameController.BridgeGame().move(position, gameController.Bridge(), count).equals("call")) {
                String get = gameController.BridgeGame().retry(gameController.inputView().readGameCommand());
                if (get.equals("playing")) {
                    count = 0;
                    gameController.round_count++;
                    continue;
                }
            }
            gameController.outputView().printMap();
            count++;
            gameController.total_print();
        }
    }
}

