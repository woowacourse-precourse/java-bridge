package bridge.domain.code;

import java.util.Arrays;

public enum RestartCommand {
    RESTART("R"),
    QUIT("Q");

    public static final String ERROR_DID_NOT_FOUND_RESTART_CODE = "[ERROR] 재시작/종료 명령어가 아닙니다.";
    private final String commandCode;

    RestartCommand(final String commandCode) {
        this.commandCode = commandCode;
    }

    public static RestartCommand generateCommand(final String commandCode) {
        return Arrays.stream(RestartCommand.values())
                .filter(restartCommand -> restartCommand.commandCode.equals(commandCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_DID_NOT_FOUND_RESTART_CODE));
    }

    public boolean isContinue() {
        return this.equals(RESTART);
    }
}
