package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

enum ControllerCommand {
    RETRY("R"),
    QUIT("Q");

    private final String key;

    ControllerCommand(final String key) {
        this.key = key;
    }

    public static ControllerCommand from(final String key) {
        return Arrays.stream(ControllerCommand.values())
                .filter(it -> Objects.equals(it.key, key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("R,Q 만 입력 가능합니다"));
    }

    @Override
    public String toString() {
        return "ControllerCommand : " + key;
    }
}
