package bridge.domain.constants;

import java.util.Map;

public enum Command {
    MOVE_UP("U"),
    MOVE_DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private String command;
    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
