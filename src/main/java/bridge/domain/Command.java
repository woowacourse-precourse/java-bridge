package bridge.domain;

import bridge.domain.constant.ExceptionMessage;

import java.util.Objects;

public class Command {
    private static final String RESTART_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    private final String command;

    private Command(String command) {
        this.command = command;
    }

    public static Command createCommand(String command) {
        validateCommand(command);
        return new Command(command);
    }

    private static void validateCommand(String command) {
        if (!isRestartOrQuit(command)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_APPROPRIATE_COMMAND);
        }
    }

    private static boolean isRestartOrQuit(String command) {
        return command.equals(RESTART_COMMAND) || command.equals(QUIT_COMMAND);
    }

    public static boolean isRestart(Command command) {
        return command.toString()
                .equals(RESTART_COMMAND);
    }

    @Override
    public String toString() {
        return command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command1 = (Command) o;
        return Objects.equals(command, command1.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }
}
