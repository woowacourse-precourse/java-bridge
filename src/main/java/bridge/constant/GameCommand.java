package bridge.constant;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum GameCommand {
    NOTHING(""),
    RETRY("R"),
    QUIT("Q");

    private static final Map<String, GameCommand> GAME_COMMANDS = Arrays.stream(values())
            .filter(gameCommands -> !gameCommands.is(NOTHING))
            .collect(Collectors.toMap(
                    gameCommands -> gameCommands.command, Function.identity()));

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(final String command) {
        if (!GAME_COMMANDS.containsKey(command)) {
            throw new IllegalArgumentException("R 또는 Q만 입력해 주세요. (R:재시작, Q:종료)");
        }
        return GAME_COMMANDS.get(command);
    }

    public boolean is(final GameCommand gameCommand) {
        return this == gameCommand;
    }
}
