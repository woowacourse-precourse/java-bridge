package bridge.UI.Resource;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UpDownCommand {
    UP("U", 1),
    DOWN("D", 0);
    private String command;
    private int value;

    UpDownCommand(String command, int value) {
        this.command = command;
        this.value = value;
    }
    public String command() {
        return command;
    }

    public int value() {
        return value;
    }
    private static final Map<Integer,String> COMMAND_VALUE =
            Stream.of(values()).collect(Collectors.toMap( UpDownCommand::value, UpDownCommand::command));
    public static String mapping(int way) {
        return COMMAND_VALUE.get(way);
    }
}
