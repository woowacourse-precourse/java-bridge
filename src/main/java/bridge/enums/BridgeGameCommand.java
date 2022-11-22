package bridge.enums;

import java.util.Arrays;

/**
 * 재시도 여부 문자열에 사용되는 enum
 */
public enum BridgeGameCommand {
    R(true),
    Q(false);

    private boolean bool;

    BridgeGameCommand(Boolean bool) {
        this.bool = bool;
    }

    public boolean isBool() {
        return bool;
    }

    public static boolean getBool(String name) {
        return Arrays.stream(BridgeGameCommand.values())
                .filter(command -> command.name().equals(name))
                .findAny()
                .get().isBool();
    }
}
