package bridge.domain.bridgeenum;

import bridge.domain.errorenum.ErrorMessage;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Restart {
    RESTART("R", true),
    END("Q", false);

    private static final Map<String, Boolean> COMMAND_RESTART_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(Restart::getCommand, Restart::getRestart));
    private final String command;
    private final Boolean isRestart;

    Restart(String command, boolean isRestart) {
        this.command = command;
        this.isRestart = isRestart;
    }

    public static boolean isRestart(String command) {
        validateRestartCommand(command);
        return COMMAND_RESTART_MAP.get(command);
    }

    public String getCommand() {
        return command;
    }

    private Boolean getRestart() {
        return isRestart;
    }

    private static void validateRestartCommand(String command) {
        if (COMMAND_RESTART_MAP.containsKey(command)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_IN_RESTART.printMessage());
    }


}
