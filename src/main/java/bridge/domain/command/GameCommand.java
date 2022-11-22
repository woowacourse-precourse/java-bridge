package bridge.domain.command;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toUnmodifiableMap;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q"),
    ;

    private static final String NOT_MATCH_COMMAND = "게임 재시도 여부는 R 또는 Q만이 입력 가능합니다.";

    private static final Map<String, GameCommand> BY_SHORTCUT =
            stream(values()).collect(toUnmodifiableMap(GameCommand::shortcut, command -> command));

    private final String shortcut;

    GameCommand(final String shortcut) {
        this.shortcut = shortcut;
    }

    public static GameCommand of(final String shortcut) {
        return ofNullable(BY_SHORTCUT.get(shortcut))
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_COMMAND));
    }

    public String shortcut() {
        return shortcut;
    }
}
