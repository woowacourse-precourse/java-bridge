package bridge.domain;

import java.util.Arrays;

public enum BridgeLine { // BridgeDirectionType?
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String command;

    BridgeLine(int number, String command) {
        this.number = number;
        this.command = command;
    }

    public static BridgeLine findByNumber(int number) {
        return Arrays.stream(BridgeLine.values())
                .filter(bridgeDirectionType -> bridgeDirectionType.number == number)
                .findAny()
                .orElseThrow();
    }

    public static BridgeLine findByCommand(String command){
        return Arrays.stream(BridgeLine.values())
                .filter(bridgeLine -> bridgeLine.command == command)
                .findAny()
                .orElseThrow();
    }

    public String getCommand() {
        return this.command;
    }
}
