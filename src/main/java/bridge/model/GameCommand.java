package bridge.model;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"), QUIT("Q");
    private static final String ERR_GAME_COMMAND_FORMAT = "게임 재시도는 'R', 종료는 'Q'를 입력하세요. 대소문자 구별. 예시) R(O), Q(O), r(X)";
    private final String inputFormat;

    GameCommand(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public static GameCommand toGameCommand(String format) {
        return Arrays.stream(GameCommand.values()).sequential()
                .filter(gameCommand -> gameCommand.inputFormat.equals(format))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_GAME_COMMAND_FORMAT));
    }

    public boolean isRetry() {
        return this == RETRY;
    }
}
