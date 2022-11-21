package bridge;

import bridge.controller.Game;
import bridge.view.TypeChange;
import bridge.view.Valification;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(new InputView(new Valification(), new TypeChange()), new OutputView());
        game.play();
    }
}
