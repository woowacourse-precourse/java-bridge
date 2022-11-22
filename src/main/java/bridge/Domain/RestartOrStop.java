package bridge.Domain;

import java.util.Arrays;

public enum RestartOrStop {
    RESTART("R"),
    STOP("Q");

    private final String command;

    RestartOrStop(String command){
        this.command = command;
    }

    public static RestartOrStop of(String command){
        return Arrays.stream(values())
                .filter(answer -> answer.command.equals(command))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
