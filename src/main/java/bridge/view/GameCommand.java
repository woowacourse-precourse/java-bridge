package bridge.view;

public enum GameCommand {
    QUIT("Q"),
    REPLAY("R");

    private static final String INVALID_GAME_COMMAND = "게임 재시도 여부가 올바르지 않습니다.";

    public String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String command) {
        if (command.equals(QUIT.command)) {
            return QUIT;
        }
        if (command.equals(REPLAY.command)) {
            return REPLAY;
        }
        throw new IllegalArgumentException(INVALID_GAME_COMMAND);
    }
}
