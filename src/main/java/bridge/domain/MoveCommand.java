package bridge.domain;

import java.util.Arrays;

public enum MoveCommand {
    UP("U", "위", 1),
    DOWN("D", "아래", 0);

    private final String command;
    private final String word;
    private final int value;

    MoveCommand(String command, String word, int value) {
        this.command = command;
        this.word = word;
        this.value = value;
    }

    public String getCommand() {
        return command;
    }

    public String getWord() {
        return word;
    }

    public int getValue() {
        return value;
    }

    public static String parseValueToCommand(int value) {
        return Arrays.stream(MoveCommand.values())
                .filter(move -> move.getValue() == value)
                .map(move -> move.command)
                .findFirst()
                .orElseThrow();
    }
}
