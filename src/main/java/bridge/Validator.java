package bridge;

import bridge.type.LangType;

import java.util.List;

public class Validator {
    public static void checkCommand(List<String> allowCommands, String command) {
        if (!allowCommands.contains(command)) {
            String message = LangType.format(LangType.THROW_WRONG_COMMAND, joinCommands(allowCommands));
            throw new IllegalArgumentException(message);
        }
    }

    private static String joinCommands(List<String> commands) {
        return String.join(",", commands);
    }
}
