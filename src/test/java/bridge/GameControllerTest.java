package bridge;

import org.junit.jupiter.api.Test;

class GameControllerTest {
    @Test
    void createBridgeSizeTest() {
        InputView inputView = new InputView();
        GameController gameController = new GameController();
        gameController.createBridgeSize(inputView);
    }

}