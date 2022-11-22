package bridge.utils.command;

import java.util.Arrays;

public enum GameCommand {

    COMMAND_RESTART("R"),
    COMMAND_QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static boolean contains(String status) {
        return Arrays.stream(values())
                .anyMatch(cmd -> cmd.command.equals(status));
    }

    public String getCommand() {
        return command;
    }

    public boolean equals(String input) {
        return this.command.equals(input);
    }
    
}
