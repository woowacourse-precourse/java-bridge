package bridge.domain.game;

public class Command {

    private static final String REG_XP_RETRY_COMMAND = "[RQ]+";
    private static final int COMMAND_SIZE = 1;

    private final String command;

    public Command(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        validateCommandForm(command);
        validateCommandSize(command);
    }

    private void validateCommandForm(String command) {
        if (!command.matches(REG_XP_RETRY_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] 재시작 여부 명령어는 R와 Q 문자만 입력 가능합니다.");
        }
    }

    private void validateCommandSize(String command) {
        if (command.length() != COMMAND_SIZE) {
            throw new IllegalArgumentException("[ERROR] 재시작 여부 명령어는 R와 Q 문자 중 하나만 입력 가능합니다.");
        }
    }
}
