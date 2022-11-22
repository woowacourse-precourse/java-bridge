package bridge.Vaildator;

import bridge.Constant;

public class VaildatorBridgeSize {

    private static String userInputBridgeString;
    private static int userInputBridgeSize;


    public VaildatorBridgeSize(String userInputBridgeString) {
        this.userInputBridgeString = userInputBridgeString;

        validate();
    }

    private void validate() {
        integerValidate();
        rangeValidate();
    }

    private void integerValidate() {
        if (!userInputBridgeString.matches(Constant.REGEX)) {
            throw new IllegalArgumentException(Constant.ERROR + Constant.INPUT_BRIDGE_SIZE_STRING);
        }
    }

    private void rangeValidate() {
        userInputBridgeSize = Integer.parseInt(userInputBridgeString);

        if (!(userInputBridgeSize >= Constant.MIN && userInputBridgeSize <= Constant.MAX)) {
            throw new IllegalArgumentException(Constant.ERROR + Constant.INPUT_BRIDGE_SIZE_WRONG_RANGE);
        }

    }

    public static int getUserInputBridgeSize(){
        return userInputBridgeSize;
    }


}
