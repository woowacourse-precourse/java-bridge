package bridge.domain;

import bridge.common.ErrorMessage;
import java.util.Arrays;

public enum Move {
    UP(1, "U"),
    DOWN(0, "D");

    private final int bridgeNumber;
    private final String command;

    Move(int bridgeNumber, String command) {
        this.bridgeNumber = bridgeNumber;
        this.command = command;
    }

    public static Move of(String command) {
        return Arrays.stream(values())
                .filter(move -> move.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.isInvalidMovingCommand()));
    }

    public static String getCommandByBridgeNumber(int bridgeNumber) {
        return Arrays.stream(values())
                .filter(move -> move.bridgeNumber == bridgeNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.isInvalidMovingCommand()))
                .command;
    }
}
