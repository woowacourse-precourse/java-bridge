package bridge;

import java.util.ArrayList;
import java.util.List;

public class UserInputException extends Exception {
    private final static List<String> movePool = List.of(new String[]{"U", "D"});
    private final static List<String> processPool = List.of(new String[]{"R", "Q"});
    public static String numberCheck(String userInput) throws IllegalArgumentException {
        if (!userInput.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException();
        if (Integer.parseInt(userInput) < 3 || Integer.parseInt(userInput) > 20) throw new IllegalArgumentException();
        return userInput;
    }

    public static String commandCheck(String userInput, String commandType) throws IllegalArgumentException {
        if (commandType.equals("move")) {
            if (!movePool.contains((userInput))) throw new IllegalArgumentException();
        }
        if (commandType.equals("process")) {
            if (!processPool.contains((userInput))) throw new IllegalArgumentException();
        }
        return userInput;
    }
}
