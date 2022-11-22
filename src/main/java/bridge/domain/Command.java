package bridge.domain;

import java.util.Arrays;

public enum Command {
    UP("U"), DOWN("D"), RETRY("R"), QUIT("Q");

    final private String string;

    Command(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public static Command getCommand(final String string) {
        return Arrays.stream(values())
                .filter(value -> value.string.equals(string))
                .findAny()
                .orElse(null);
    }
}
