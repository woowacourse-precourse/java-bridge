package bridge.EnumClass;

public class Validator {
    private Validator() {}

    public static int validateBridgeInput(String input) {
        try {
            int result = Integer.parseInt(input);
            validateBridgeSize(result);
            return result;
        } catch (NumberFormatException E) {
            throw new IllegalArgumentException(EnumMassage.Error_length.getMessage());
        }
    }

    public static String validateCommand(String input, EnumConstant state) {
        if (!state.getState().contains(input)) {
            throw new IllegalArgumentException(EnumMassage.Unvalidate.getMessage());
        }
        return input;
    }

    private static void validateBridgeSize(int bridgeSize) {
        if (bridgeSize > EnumBridge.Max_cnt.getCnt() || bridgeSize < EnumBridge.Min_cnt.getCnt()) {
            throw new IllegalArgumentException(EnumMassage.Error_length.getMessage());
        }
    }

}
