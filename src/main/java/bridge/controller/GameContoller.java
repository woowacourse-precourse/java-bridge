package bridge.controller;


import bridge.view.InputView;
import bridge.view.OutputView;

public class GameContoller {
    OutputView outputView = new OutputView();

    public void run() {
//        System.out.println(InputController.readBridgeSize());
//        InputView inputView = new InputView();
//        System.out.println(InputController.readMoving());
//        System.out.println(InputController.readGameCommand());
        outputView.printStart();
    }
}
