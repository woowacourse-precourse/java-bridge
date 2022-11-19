package bridge.utils;

import static bridge.utils.ErrorMessage.INVALID_INPUT_VALUE;

public enum MoveCommand {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int code;

    MoveCommand(String command, int code) {
        this.command = command;
        this.code = code;
    }

    public String getCommand() {
        return command;
    }

    public static String of(int code) {
        for (MoveCommand move : values()) {
            if (move.code == code) {
                return move.command;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
    }

}
