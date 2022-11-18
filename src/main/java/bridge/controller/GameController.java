package bridge.controller;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController =inputController;
    }

    public void run() {
        createBridge();

    }

    private void createBridge() {
        int bridgeSizeInput = inputController.getBridgeSize();
    }
}
