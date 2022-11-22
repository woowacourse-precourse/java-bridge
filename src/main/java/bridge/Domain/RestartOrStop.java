package bridge.Domain;

import java.util.Arrays;

public enum RestartOrStop {
    RESTART("R"),
    STOP("Q");

    private final String command;

    RestartOrStop(String command) {
        this.command = command;
    }

    public boolean continueGame() {
        return this.equals(RESTART);
    }

    public boolean stopUserGame() {
        return this.equals(STOP);
    }

    public static RestartOrStop of(String command) {
        return Arrays.stream(values())
                .filter(answer -> answer.command.equals(command))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


    public static RestartOrStop restartGame() {
        return RESTART;
    }


}
