package bridge;

import bridge.logic.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.View;

public class Application {

    public static void main(String[] args) {
        View view = createView();
        BridgeGame bridgeGame = new BridgeGame();

        GameController gameController = new GameController(view, bridgeGame);
        gameController.play(1);
    }

    private static View createView() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new View(inputView, outputView);
    }

}
