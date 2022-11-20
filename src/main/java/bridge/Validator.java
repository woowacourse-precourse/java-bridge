package bridge;

import bridge.type.LangType;
import bridge.util.Parser;

import java.util.List;

public class Validator {
    public static void checkConsoleCommandIsCorrect(List<String> allowCommands, String command) {
        if (!allowCommands.contains(command)) {
            String message = LangType.format(LangType.WRONG_COMMAND, joinCommands(allowCommands));
            throw new IllegalArgumentException(message);
        }
    }

    private static String joinCommands(List<String> commands) {
        return String.join(",", commands);
    }

    public static void checkConsoleInputNumberInRange(List<Integer> range, String input) {
        int number = Parser.toIntFrom(input);
        int min = Integer.min(range.get(0), range.get(1));
        int max = Integer.max(range.get(0), range.get(1));

        if (number < min || number > max) {
            throw new IllegalArgumentException(LangType.format(LangType.INPUT_NUMBER_IN_RANGE, min, max));
        }
    }
}
