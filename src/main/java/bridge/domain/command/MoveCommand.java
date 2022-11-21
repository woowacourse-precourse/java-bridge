package bridge.domain.command;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toUnmodifiableMap;

public enum MoveCommand {

    MOVE_UP("U"),
    MOVE_DOWN("D"),
    ;

    private static final String NOT_MATCH_COMMAND = "이동 명령은 U와 D만이 입력 가능합니다.";

    private static final Map<String, MoveCommand> BY_SHORTCUT =
            stream(values()).collect(toUnmodifiableMap(MoveCommand::shortcut, command -> command));

    private final String shortcut;

    MoveCommand(final String shortcut) {
        this.shortcut = shortcut;
    }

    public static MoveCommand of(final String shortcut) {
        return ofNullable(BY_SHORTCUT.get(shortcut))
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_COMMAND));
    }

    public String shortcut() {
        return shortcut;
    }
}
