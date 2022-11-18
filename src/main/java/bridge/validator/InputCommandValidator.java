package bridge.validator;

import bridge.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCommandValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    
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
            throw new IllegalArgumentException(ERROR_MESSAGE + commandValidatorKey.getErrorMessage());
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
}
