package bridge.domain.command;

import java.util.Objects;

public class Command {

    private final static String GAME_RETRY = "R";
    private final String command;

    public Command(String input) {
        validateForm(input);
        this.command = input;
    }

    private void validateForm(String command) {
        if (!command.matches("[RQ]")) {
            throw new IllegalArgumentException("[ERROR] R 혹은 Q만 입력할 수 있습니다.");
        }
    }

    public boolean isToRetryGame() {
        return this.command.equals(GAME_RETRY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Command command1 = (Command) o;
        return command.equals(command1.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }

    @Override
    public String toString() {
        return "Command{" +
                "command='" + command + '\'' +
                '}';
    }
}
