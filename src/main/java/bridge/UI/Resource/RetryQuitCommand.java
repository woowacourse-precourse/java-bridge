package bridge.UI.Resource;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RetryQuitCommand {
    RETRY("R"),
    QUIT("Q");
    private String command;
    private int value;

    RetryQuitCommand(String command) {
        this.command = command;
    }
    public String command() {
        return command;
    }

}
