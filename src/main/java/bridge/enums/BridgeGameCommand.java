package bridge.enums;

import java.util.Arrays;

public enum BridgeGameCommand {
    R(true),
    Q(false);

    private boolean bool;

    BridgeGameCommand(Boolean bool) {this.bool = bool;}

    public boolean isBool() {
        return bool;
    }

    public static boolean toBoolean(String str) {
        return Arrays.stream(BridgeGameCommand.values())
                .filter(command -> command.name().equals(str))
                .findAny()
                .get().isBool();
    }
}
