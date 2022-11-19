package bridge;

import bridge.game.GameManager;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameManager gameManager = new GameManager(inputView, outputView);
        gameManager.run();
    }
}
