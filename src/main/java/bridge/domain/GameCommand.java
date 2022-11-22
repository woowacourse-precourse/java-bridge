package bridge.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q"),
    ;

    private final String command;
    private final static Map<String, GameCommand> gameCommandMap = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(e -> gameCommandMap.put(e.command, e));
    }

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static boolean contains(final String command) {
        return Arrays.stream(values())
                .map(GameCommand::getCommand)
                .collect(Collectors.toList())
                .contains(command);
    }

    public static GameCommand getGameCommand(final String command) {
        return gameCommandMap.get(command);
    }
}
