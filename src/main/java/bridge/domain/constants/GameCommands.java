package bridge.domain.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum GameCommands {

    NOTHING(""),
    RETRY("R"),
    QUIT("Q"),
    ;

    private static final Map<String, GameCommands> GAME_COMMANDS = Arrays.stream(values())
            .filter(gameCommands -> !gameCommands.is(NOTHING))
            .collect(Collectors.toUnmodifiableMap(
                    gameCommands -> gameCommands.command, Function.identity()));

    private final String command;

    GameCommands(String command) {
        this.command = command;
    }

    public static GameCommands of(final String command) {
        if (!GAME_COMMANDS.containsKey(command)) {
            throw new IllegalArgumentException("R 또는 Q만 입력해 주세요. (R:재시작, Q:종료)");
        }
        return GAME_COMMANDS.get(command);
    }

    public boolean is(final GameCommands gameCommand) {
        return this == gameCommand;
    }
}
