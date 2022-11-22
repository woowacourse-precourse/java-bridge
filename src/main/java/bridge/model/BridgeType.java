package bridge.model;

import java.util.Arrays;

public enum BridgeType {
    UP_BRIDGE("U", "위", 1),
    DOWN_BRIDGE("D", "아래", 0),
    ;

    private final String command;

    private final String position;

    private final int bridgeNumber;

    BridgeType(String command, String position, int bridgeNumber) {
        this.command = command;
        this.position = position;
        this.bridgeNumber = bridgeNumber;
    }

    public static String convertRandomNumberToCommand(int randomNumber) {
        return Arrays.stream(BridgeType.values())
                .filter(bridgeType -> bridgeType.bridgeNumber == randomNumber)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("허용되지 않는 랜덤 숫자입니다. 일치하는 텍스트를 찾을 수 없습니다."))
                .command;
    }

    public static BridgeType searchBridgeByCommand(String command) {
        return Arrays.stream(BridgeType.values())
                .filter(bridgeType -> bridgeType.isEqualCommand(command))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("허용되지 않는 글자입니다. 일치하는 다리를 찾을 수 없습니다."));
    }

    public String getCommand() {
        return command;
    }

    public String getPosition() {
        return position;
    }

    public boolean isEqualCommand(String compareCommand) {
        return command.equals(compareCommand);
    }
}
