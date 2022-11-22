package bridge;

import bridge.Vaildator.VaildatorBridgeSize;
import bridge.Vaildator.VaildatorRetryQuit;
import bridge.Vaildator.VaildatorUpDown;

public class BridgeInputControl {

    public static UserInput setBridgeSize() {
        try {
            VaildatorBridgeSize validationSize = new VaildatorBridgeSize(InputView.readBridgeSize());
            return new UserInput(validationSize.userInputBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }

    public static UserInput setUpDown() {
        try {
            VaildatorUpDown validationUpDown = new VaildatorUpDown(InputView.readBridgeSize());
            return new UserInput(validationUpDown.userInputUpDown);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }

    public static UserInput setRetryQuit() {
        try {
            VaildatorRetryQuit validationRQ = new VaildatorRetryQuit(InputView.readBridgeSize());
            return new UserInput(validationRQ.userInputRetryQuit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }



}
