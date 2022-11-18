package bridge.controller;

public class GameController {

    private InputController inputController;

    public GameController gameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        Bridge bridge = creatBridge();
    }

    private Bridge createBridge() {
        int bridgeSizeInput = inputController.getBridgeSize();
    }
}
