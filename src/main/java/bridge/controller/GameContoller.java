package bridge.controller;

import bridge.view.InputView;

public class GameContoller {
    public void run(){
        InputView inputView = new InputView();
        System.out.println(inputView.readBridgeSize());
    }
}
