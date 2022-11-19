package bridge.controller;

import bridge.view.InputView;

public class Controller {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";

    public void run() {
        InputView inputView = new InputView();
        System.out.println(GAME_START);
        startGame(inputView);
    }

    private void startGame(InputView inputView) {
        try {
            inputView.readBridgeSize();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
