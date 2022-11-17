package bridge.validator;

public class InputBridgeSizeValidator {
    
    public static void validate(final String inputBridgeSize) {
        validatorNullOrEmpty(inputBridgeSize);
    }
    
    private static void validatorNullOrEmpty(final String inputBridgeSize) {
        InputCommonValidator.validate(inputBridgeSize);
    }
}
