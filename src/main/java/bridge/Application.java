package bridge;

import bridge.controller.InputController;
import bridge.domain.BridgeGame;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        InputView.guideStart();
        int size = InputController.checkSize(new InputView());
        BridgeGame game = new BridgeGame(size);
        game.play();
    }
}
