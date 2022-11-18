package bridge;

import java.util.Arrays;

public enum BridgeStep {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String command;

    BridgeStep(int number, String command) {
        this.number = number;
        this.command = command;
    }

    public static BridgeStep findByNumber(int number) {
        return Arrays.stream(BridgeStep.values())
                .filter(bridgeStep -> bridgeStep.number == number)
                .findAny()
                .orElseThrow();
    }

    public String getCommand() {
        return this.command;
    }
}
