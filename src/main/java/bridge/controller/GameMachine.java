package bridge.controller;

import bridge.view.InputView;
import bridge.view.MessageView;
import bridge.view.OutputView;

public class GameMachine {
    InputView inputView;
    OutputView outputView;

    public GameMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    void play() {
        System.out.println(MessageView.PLAY_BRIDGE_GAME.getMessage());
        System.out.println(MessageView.INPUT_BRIDGE_LENGTH);
        inputView.readBridgeSize();
    }
}
