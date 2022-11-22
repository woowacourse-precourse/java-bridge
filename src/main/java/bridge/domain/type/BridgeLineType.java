package bridge.domain.type;

import bridge.validator.MoveCommandValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BridgeLineType {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String command;

    BridgeLineType(int number, String command) {
        this.number = number;
        this.command = command;
    }

    private static String getValidNumbers() {
        List<String> validNumbers = new ArrayList<>();
        Arrays.stream(BridgeLineType.values()).forEach(bridgeLine -> {
            validNumbers.add(String.valueOf(bridgeLine.number));
        });
        return String.join(", ", validNumbers);
    }

    public static BridgeLineType findByNumber(int number) {
        return Arrays.stream(BridgeLineType.values())
                .filter(bridgeLine -> bridgeLine.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("[ERROR] 브릿지 라인의 넘버는 %s만 입력할 수 있습니다.", getValidNumbers())
                ));
    }

    public static BridgeLineType findByCommand(String inputCommand) {
        MoveCommandValidator validator = new MoveCommandValidator();
        String command = validator.getValidCommand(inputCommand);
        return Arrays.stream(BridgeLineType.values())
                .filter(bridgeLine -> bridgeLine.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("[ERROR] 브릿지 라인의 커맨드는 %s만 입력할 수 있습니다.", validator.getCommandsDescription())
                ));
    }

    public String getCommand() {
        return this.command;
    }
}
