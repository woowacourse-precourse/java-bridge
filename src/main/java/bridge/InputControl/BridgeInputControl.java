package bridge.InputControl;

import bridge.InputView;
import bridge.Vaildator.VaildatorBridgeSize;
import bridge.Vaildator.VaildatorRetryQuit;
import bridge.Vaildator.VaildatorUpDown;

public class BridgeInputControl {

    public static UserInput setBridgeSize() {
        try {
            VaildatorBridgeSize validationSize = new VaildatorBridgeSize(InputView.readBridgeSize());
            return new UserInput(validationSize.getUserInputBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }

    public static UserInput setUpDown() {
        try {
            VaildatorUpDown validationUpDown = new VaildatorUpDown(InputView.readMoving());
            return new UserInput(validationUpDown.getUserInputUpDown());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }

    public static UserInput setRetryQuit() {
        try {
            VaildatorRetryQuit validationRQ = new VaildatorRetryQuit(InputView.readGameCommand());
            return new UserInput(validationRQ.getUserInputRetryQuit());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }


}
