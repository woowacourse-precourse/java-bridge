package bridge.validator;

public class InputSelectCharValidator {
    public static void validate(final String inputMoving) {
        validateNullOrEmpty(inputMoving);
    }
    
    private static void validateNullOrEmpty(final String inputMoving) {
        InputCommonValidator.validate(inputMoving);
    }
}
