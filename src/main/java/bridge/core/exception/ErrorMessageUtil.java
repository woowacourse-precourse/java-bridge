package bridge.core.exception;

public class ErrorMessageUtil {

    private static final String SPECIFIER = "%";

    public static String parseMessage(String message, String... args) {
        if (validate(message, args)) return message;

        for (int idx = 0; idx < args.length; idx++) {
            String replaceChar = SPECIFIER + (idx + 1);
            message = message.replaceFirst(replaceChar, args[idx]);
        }
        return message;
    }

    private static boolean validate(String message, String[] args) {
        if (message == null || message.trim().length() <= 0)
            return true;
        if (args == null || args.length <= 0)
            return true;
        String[] splitMessages = message.split(SPECIFIER);
        if (splitMessages == null || splitMessages.length <= 1)
            return true;
        return false;
    }
}
