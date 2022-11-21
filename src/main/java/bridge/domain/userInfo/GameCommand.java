package bridge.domain.userInfo;

public class GameCommand {

    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String COMMAND_BLANK_ERROR = "입력 값은 비어있을 수 없습니다.";
    private static final String COMMAND_FORMAT_ERROR = "R 또는 Q 만 입력해야합니다.";

    private final String command;

    public GameCommand(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        checkNotBlank(command);
        checkFormatValid(command);
    }

    private void checkNotBlank(String command) {
        boolean isBlank = command.isBlank();
        if (isBlank) {
            throw new IllegalArgumentException(COMMAND_BLANK_ERROR);
        }
    }

    private void checkFormatValid(String direction) {
        boolean isFormatValid = direction.equals(RETRY) || direction.equals(QUIT);
        if (!isFormatValid) {
            throw new IllegalArgumentException(COMMAND_FORMAT_ERROR);
        }
    }

    public boolean isSameQuit() {
        return command.equals("Q");
    }
}
