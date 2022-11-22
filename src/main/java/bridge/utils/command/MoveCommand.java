package bridge.utils.command;

import java.util.Arrays;

import static bridge.utils.message.ErrorMessage.INVALID_INPUT_VALUE;

public enum MoveCommand {

    COMMAND_UP("U", 1),
    COMMAND_DOWN("D", 0);

    private final String command;
    private final int code;

    MoveCommand(String command, int code) {
        this.command = command;
        this.code = code;
    }

    public static boolean contains(String status) {
        return Arrays.stream(values())
                .anyMatch(cmd -> cmd.command.equals(status));
    }

    public static String of(int code) {
        for (MoveCommand move : values()) {
            if (move.code == code) {
                return move.command;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
    }

    public boolean equals(String input) {
        return this.command.equals(input);
    }
    
}
