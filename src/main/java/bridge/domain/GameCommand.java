package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    R, Q;

    public static GameCommand of(String gameCommand) {
        return Arrays.stream(values())
            .filter(command -> command.name().equals(gameCommand))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] R 혹은 Q만 입력 가능합니다."));
    }
}
