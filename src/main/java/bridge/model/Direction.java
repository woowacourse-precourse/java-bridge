package bridge.model;

import java.util.Arrays;

public enum Direction {
    UP("U"),
    DOWN("D");

    private String command;

    Direction(String command) {
        this.command = command;
    }

    public static Direction find(String command) {
        return Arrays.stream(values())
                .filter(direction -> command.equals(direction.command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다. U 또는 D를 입력해주세요."));
    }

    public boolean correct(String command) {
        return command.equals(this.command);
    }
}
