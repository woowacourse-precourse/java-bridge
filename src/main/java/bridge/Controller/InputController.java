package bridge.Controller;

import bridge.View.InputView;

public class InputController {
    private String movement;
    private String command;
    private int bridgeSize;
    public InputController(){
        this.movement = InputView.readMoving();
        this.command = InputView.readGameCommand();
        this.bridgeSize = InputView.readBridgeSize();
    }

    public int getBridgeSize(){
        return bridgeSize;
    }
    public String getMovement(){
        return movement;
    }
    public String getCommand(){
        return command;
    }
}
