package bridge;

public class ErrorMessageGenerator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static String generate(String message) {
        StringBuilder errorMessage = new StringBuilder(ERROR_MESSAGE);

        errorMessage.append(message);
        return errorMessage.toString();
    }
}
