package bridge;

public class Validation {
    public static void isInputIncludeCharacter(String input) {
        String result = input.replaceAll("[0-9]", "");
        if (result.length() != 0)
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INPUT_INCLUDE_CHARACTER.getMessage());
    }
}
