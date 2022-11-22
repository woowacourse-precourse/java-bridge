package bridge.input.validate;

import bridge.domain.GameCommand;
import bridge.domain.MoveCommand;

import java.util.List;
import java.util.regex.Pattern;

import static bridge.controller.BridgeSize.MAXIMUM;
import static bridge.controller.BridgeSize.MINIMUM;

public class BasicBridgeValidator implements BridgeValidator {
    private static BasicBridgeValidator instance;
    private BasicBridgeValidator() {
    }

    public static BasicBridgeValidator getInstance() {
        if (instance == null) {
            instance = new BasicBridgeValidator();
        }
        return instance;
    }

    @Override
    public void validateBridgeSize(final String size) throws IllegalArgumentException {
        validateInteger(size);
        validateSizeRange(size);
    }

    @Override
    public void validateMoveCommand(final String command) throws IllegalArgumentException {
        validateStringMoveCommand(command);
    }

    @Override
    public void validateGameCommand(final String command) throws IllegalArgumentException {
        validateStringGameCommand(command);
    }

    @Override
    public void validateBridge(final List<String> bridge) throws IllegalArgumentException {
        validateBridgeSize(String.valueOf(bridge.size()));
        for (String command : bridge) {
            if (!Pattern.matches("^[UD]$", command)) {
                String errMessage = "[ERROR] 다리는 U, D만 포함하고 있어야 합니다.";
                System.out.println(errMessage);
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateInteger(final String size) {
        if (!Pattern.matches("^[0-9]*$", size)) {
            String errMessage = "[ERROR] 다리 길이는 자연수만 입력 가능합니다.";
            System.out.println(errMessage);
            throw new IllegalArgumentException();
        }
    }

    private void validateSizeRange(final String size) {
        int sizeValue = Integer.parseInt(size);
        if (sizeValue < MINIMUM.getSize() | sizeValue > MAXIMUM.getSize()) {
            String errMessage = String.format("[ERROR] 다리 길이는 %d 이상 %d 이하만 가능합니다.", MINIMUM.getSize(), MAXIMUM.getSize());
            System.out.println(errMessage);
            throw new IllegalArgumentException();
        }
    }

    private void validateStringMoveCommand(final String command) {
        final MoveCommand[] moveCommands = MoveCommand.values();
        for (MoveCommand moveCommand : moveCommands) {
            if (command.equals(moveCommand.getCommand())) {
                return;
            }
        }
        String errMessage = "[ERROR] 이동 명령은 정해진 문자만 가능합니다. INPUT : " + command;
        System.out.println(errMessage);
        throw new IllegalArgumentException();
    }

    private void validateStringGameCommand(final String command) {
        final GameCommand[] gameCommands = GameCommand.values();
        for (GameCommand gameCommand : gameCommands) {
            if (command.equals(gameCommand.getCommand())) {
                return;
            }
        }
        String errMessage = "[ERROR] 재시작/종료 입력은 정해진 문자만 가능합니다.";
        System.out.println(errMessage);
        throw new IllegalArgumentException();
    }
}
