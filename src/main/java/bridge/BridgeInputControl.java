package bridge;

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




}
