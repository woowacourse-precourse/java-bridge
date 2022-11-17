package bridge.controller;

import bridge.view.InputView;

public class Game {

    private InputView inputView;

    public Game() {
        inputView = new InputView();
    }

    public void play() {
        int input = inputView.readBridgeSize();
    }
}
