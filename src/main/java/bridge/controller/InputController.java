package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeMaker;
import bridge.model.MoveBox;
import bridge.model.RestartStatus;
import bridge.model.LengthBridge;
import bridge.view.InputView;
import java.util.List;

public class InputController {

    public static List<String> getBridgeMaker() {
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            return bridgeMaker.makeBridge(new LengthBridge(InputView.readBridgeSize()).getLength());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeMaker();
        }
    }

    public static MoveBox getUserMoveBox() {
        try {
            return new MoveBox(InputView.readMoving());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserMoveBox();
        }
    }

    public static RestartStatus getRestartStatus(){
        try{
            return new RestartStatus(InputView.readGameCommand());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getRestartStatus();
        }
    }


}