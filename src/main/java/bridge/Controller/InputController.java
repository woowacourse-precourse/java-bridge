package bridge.Controller;

import bridge.View.InputView;

public class InputController {
    public int getBridgeSize(){
        return InputView.readBridgeSize();
    }
    public String getMovement(){
        return InputView.readMoving();
    }
    public String getCommand(){
        return InputView.readGameCommand();
    }
}
