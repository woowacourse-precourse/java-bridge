package bridge;

import bridge.controller.GameControll;
import bridge.view.TypeChange;
import bridge.view.Valification;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameControll gameControll = new GameControll(new InputView(new Valification(), new TypeChange()), new OutputView());
        gameControll.play();
    }
}
