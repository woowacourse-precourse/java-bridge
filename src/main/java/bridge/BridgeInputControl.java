package bridge;

import bridge.Vaildator.VaildatorBridgeSize;
import bridge.Vaildator.VaildatorUpDown;

public class BridgeInputControl {

    public static UserInput setBridgeSize() {
        try {
            VaildatorBridgeSize validation = new VaildatorBridgeSize(InputView.readBridgeSize());
            return new UserInput(validation.userInputBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }

    public static UserInput setUpDown() {
        try {
            VaildatorUpDown validation = new VaildatorUpDown(InputView.readBridgeSize());
            return new UserInput(validation.userInputUpDown);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }




}
