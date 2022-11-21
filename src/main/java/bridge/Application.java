package bridge;

import bridge.view.GameView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        GameView gameView = new GameView(outputView);

        gameView.makeBridge();
        gameView.move();
    }
}
