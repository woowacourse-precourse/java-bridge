package bridge.controller;


import bridge.view.InputView;

public class GameContoller {
    public void run() {
//        System.out.println(InputController.readBridgeSize());
        InputView inputView = new InputView();
//        System.out.println(InputController.readMoving());
        System.out.println(InputController.readGameCommand());
    }
}
