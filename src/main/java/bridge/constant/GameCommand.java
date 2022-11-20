package bridge.constant;

import java.util.Arrays;

public enum GameCommand {

    RESTART("R"), QUIT("Q");

    public static final String ERROR_INVALID_INPUT_COMMAND = "[ERROR] 게임 재시작/종료 여부 입력의 경우 R과 Q 뿐이어야 합니다.";
    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static void validateInput(String command) {
        Arrays.stream(GameCommand.values())
                .map(GameCommand::getCommand)
                .filter(s -> s.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_INPUT_COMMAND));
    }

    public static GameCommand of(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(bridgeMark -> bridgeMark.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_INPUT_COMMAND));
    }

    private boolean equals(String command) {
        return this.command.equals(command);
    }

    public boolean isRestart() {
        return this == RESTART;
    }

    public boolean isQuit() {
        return this == QUIT;
    }

    public String getCommand() {
        return command;
    }
}
