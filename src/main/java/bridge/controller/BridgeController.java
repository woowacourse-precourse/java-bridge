package bridge.controller;

import bridge.view.InputView;

public class BridgeController {
    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        inputView.readBridgeSize();
    }
}
