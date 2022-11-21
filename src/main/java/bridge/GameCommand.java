package bridge;

public class GameCommand {

    private final String command;
    private static final String WRONG_COMMAND = "[ERROR] 재시도 여부는 R(재시도) 또는 Q(종료)여야 합니다.";

    public GameCommand() {
        String command = InputView.readGameCommand();
        validateCommand(command);
        this.command = command;
    }

    public String get() {
        return this.command;
    }

    private void validateCommand(String command) {
        if (!(command == "R" || command == "Q"))
            throw new IllegalArgumentException(WRONG_COMMAND);
    }
}
