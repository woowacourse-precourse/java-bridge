package bridge.Controller;

import bridge.View.InputView;

public class InputController {

    private String movement;
    private String command;
    private int bridgeSize;
    public InputController(){
    }

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
