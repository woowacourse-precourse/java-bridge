package bridge.controller;

import bridge.view.OutputView;

public class GameController {
    public void play() {
        InputController inputController = new InputController();
        OutputView outputView = new OutputView();

        outputView.printStartGame();
        inputController.setBridgeSize();
        inputController.setMove();

    }

}
