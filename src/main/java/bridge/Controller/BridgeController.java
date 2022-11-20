package bridge.Controller;

import bridge.InputView;
import bridge.OutputView;

public class BridgeController {

    private static InputView inputView = new InputView();
    public void start(){
        GameStartMessage();
        GameTest();
    }

    public void GameStartMessage(){
        OutputView.printGameStart();
    }

    public void GameTest(){
        inputView.readBridgeSize();
        inputView.readMoving();
    }
}
