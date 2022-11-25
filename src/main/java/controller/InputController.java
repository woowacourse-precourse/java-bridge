package controller;

import view.InputView;

public class InputController {
    public static String checkRestartOrExit() {
        return InputView.readGameCommand();
    }

}
