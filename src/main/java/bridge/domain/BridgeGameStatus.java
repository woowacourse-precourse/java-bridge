package bridge.domain;

public class BridgeGameStatus {
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";
    private static final String INVALID_GAME_COMMAND_MESSAGE = "[ERROR] 게임 시도 여부는 재시도(R) 또는 종료(Q)를 입력해야 합니다.";
    private String command;

    public BridgeGameStatus(String command) {
        this.command = command;
    }

    private void validateGameCommand(String command) {
        if (command.equals(RETRY_COMMAND) || command.equals(QUIT_COMMAND)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_GAME_COMMAND_MESSAGE);
    }

    public boolean isRunning() {
        return command.equals(RETRY_COMMAND);
    }

    public void changeStatus(String command) {
        validateGameCommand(command);
        this.command = command;
    }
}
