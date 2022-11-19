package bridge.domain.command;

import static java.util.Arrays.stream;

public enum MoveCommand {

    MOVE_UP("U"),
    MOVE_DOWN("D"),
    ;

    private static final String NOT_MATCH_COMMAND = "이동 명령은 U와 D만이 입력 가능합니다.";

    private final String command;

    MoveCommand(final String command) {
        this.command = command;
    }

    public static MoveCommand of(final String command) {
        return stream(values())
                .filter(c -> c.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_COMMAND));
    }
}
