package bridge.controller;

import bridge.model.Bridge;
import bridge.view.InputView;
import bridge.view.MessageView;
import bridge.view.OutputView;

public class GameMachine {
    InputView inputView;
    OutputView outputView;

    public GameMachine(InputView inputView) {
        this.inputView = inputView;
        this.outputView = inputView.getOutputView();
        play();
    }
    void play() {
        inputView.readBridgeSize();
        inputView.readMoving();
    }
}
