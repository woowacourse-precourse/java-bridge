package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.test.BridgeMaker;
import bridge.test.MoveBox;
import bridge.test.RestartStatus;
import bridge.test.lengthBridge;
import bridge.view.InputView;
import java.util.List;

public class InputController {

    public static List<String> getBridgeMaker() {
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            return bridgeMaker.makeBridge(new lengthBridge(InputView.readBridgeSize()).getLength());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeMaker();
        }
    }

    public static String getUserMoveBox() {
        try {
            return new MoveBox(InputView.readMoving()).getMovebox();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserMoveBox();
        }
    }

    public static String getRestartStatus() {
        try {
            return new RestartStatus(InputView.readGameCommand()).getRestart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRestartStatus();
        }
    }


}
