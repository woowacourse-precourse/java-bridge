package bridge.dto;

import bridge.util.StringUtils;

import java.util.regex.Pattern;

public class Command {
    private static final String COMMAND_PATTERN = "^[R|Q]$";
    private static final String BLANK_EXCEPTION_MESSAGE = "Null 또는 Empty 를 입력할 수 없습니다.";
    private static final String VALUE_EXCEPTION_MESSAGE = "R 또는 Q 만 입력할 수 있습니다.";

    private final String command;

    public Command(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(final String command) {
        validateByBlank(command);
        validateByValue(command);
    }

    private static void validateByValue(final String command) {
        if (!Pattern.matches(COMMAND_PATTERN, command)) {
            throw new IllegalArgumentException(VALUE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateByBlank(final String command) {
        if (StringUtils.isBlank(command)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    public String getCommand() {
        return command;
    }
}
