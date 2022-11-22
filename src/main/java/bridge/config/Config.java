package bridge.config;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Config {
    public static GameController gameController() {
        return new GameController(initInputView(), initOutputView());
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }

    private static InputView initInputView() {
        return new InputView();
    }


}
