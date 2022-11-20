package bridge.constant;

import java.util.Arrays;

public enum GameCommand {

    RETRY("R"), QUIT("Q");

    public static final String ERROR_INVALID_INPUT_COMMAND = "[ERROR] 게임 재시작/종료 여부 입력의 경우 R과 Q 뿐이어야 합니다.";
    private final String mark;

    GameCommand(String mark) {
        this.mark = mark;
    }

    public static void validateInput(String commandMark) {
        Arrays.stream(GameCommand.values())
                .map(GameCommand::name)
                .filter(s -> s.equals(commandMark))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_INPUT_COMMAND));
    }
}
