package bridge.util;

public class Validator {
    public static boolean isEmpty(String input){
        return input.isEmpty();
    }

    public static boolean hasNotCharacter(String input){
        final String REGEX = "[0-9]+";
        if (!input.matches(REGEX)) {
            return false;
        }

        return true;
    }
}
