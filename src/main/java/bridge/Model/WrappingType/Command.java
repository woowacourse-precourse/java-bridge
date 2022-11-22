package bridge.Model.WrappingType;

public class Command {
    private static final String QUIT = "Q";
    private static final String RETRY = "R";

    private final String command;

    public Command(String command) {
        validData(command);
        this.command = command;
    }

    public void validData(String command) throws IllegalArgumentException {
        if (command.equals(QUIT) || command.equals(RETRY)) {
            return;
        }

        throw new IllegalArgumentException("올바른 값을 입력해주세요");
    }

    public boolean isQuit() {
        return command.equals(QUIT);
    }

    public boolean isRetry() {
        return command.equals(RETRY);
    }
}
