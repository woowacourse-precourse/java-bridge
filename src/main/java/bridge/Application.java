package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int size = InputView.readBridgeSize();

        GameController gameController = new GameController();
        List<String> bridge = gameController.bridge(size);
        gameController.gameStart(bridge);
        gameController.gameResult();
    }
}