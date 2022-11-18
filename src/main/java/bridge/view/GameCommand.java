package bridge.view;

public enum GameCommand {
    QUIT,
    REPLAY;

    private static final String INVALID_GAME_COMMAND = "게임 재시도 여부가 올바르지 않습니다.";

    public static GameCommand of(String command) {
        if (command.equals("Q")) {
            return QUIT;
        }
        if (command.equals("R")) {
            return REPLAY;
        }
        throw new IllegalArgumentException(INVALID_GAME_COMMAND);
    }
}
