package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;

public class GameContoller {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();

    public void run() {
//        System.out.println(inputController.readBridgeSize());
//        System.out.println(inputController.readMoving());
//        System.out.println(inputController.readGameCommand());
//        outputView.printStart();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        System.out.println(bridgeMaker.makeBridge(3));
    }
}
