package bridge.validator;

import bridge.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCommandValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String MOVING_COMMAND_ERROR_MESSAGE = "U 또는 D 만 입력할 수 있습니다.";
    private static final String RETRY_COMMAND_ERROR_MESSAGE = "Q 또는 R 만 입력할 수 있습니다.";
    
    private InputCommandValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String command, final CommandValidatorKey commandValidatorKey) {
        validateNullOrEmpty(command);
        validateCommandForm(command, commandValidatorKey);
    }
    
    private static void validateNullOrEmpty(final String command) {
        InputCommonValidator.validate(command);
    }
    
    private static void validateCommandForm(final String command, final CommandValidatorKey commandValidatorKey) {
        if (isNotMatchCommandForm(command, commandValidatorKey)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + parseErrorMessage(commandValidatorKey));
        }
    }
    
    private static boolean isNotMatchCommandForm(final String command, final CommandValidatorKey commandValidatorKey) {
        return !matcher(command, commandForm(commandValidatorKey)).matches();
    }
    
    private static String commandForm(final CommandValidatorKey commandValidatorKey) {
        return commandValidatorKey.getCommandForm();
    }
    
    private static Matcher matcher(final String command, final String correctInputForm) {
        return compiler(correctInputForm).matcher(command);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
    
    private static String parseErrorMessage(final CommandValidatorKey commandValidatorKey) {
        if (isMovingCommandValidator(commandValidatorKey)) {
            return MOVING_COMMAND_ERROR_MESSAGE;
        }
        
        return RETRY_COMMAND_ERROR_MESSAGE;
    }
    
    private static boolean isMovingCommandValidator(final CommandValidatorKey commandValidatorKey) {
        return commandValidatorKey.isMovingCommandValidatorKey();
    }
}
