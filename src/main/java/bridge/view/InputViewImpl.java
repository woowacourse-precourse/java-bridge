package bridge.view;

import static bridge.type.CommonConstantType.MAX_BRIDGE_SIZE;
import static bridge.type.CommonConstantType.MIN_BRIDGE_SIZE;
import static bridge.type.ErrorMessageUserType.INVALID_BRIDGE_SIZE;
import static bridge.type.ErrorMessageUserType.INVALID_IN_GAME_COMMAND;
import static bridge.type.ErrorMessageUserType.INVALID_NUMBER_FORMAT;

import bridge.type.FailMenuCommandType;
import bridge.type.InGameCommandType;
import bridge.utils.InputReader;

public class InputViewImpl implements InputView {

    @Override
    public int readBridgeSize() {
        String input = InputReader.readLine();
        checkNumberFormat(input);

        int bridgeSize = Integer.parseInt(input);
        checkBridgeSizeRange(bridgeSize);

        return bridgeSize;
    }

    private void checkNumberFormat(String input) {
        boolean hasWrongNumberFormat = !input.chars().allMatch(Character::isDigit);
        if (hasWrongNumberFormat) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.toString());
        }
    }

    private void checkBridgeSizeRange(int bridgeSize) {
        boolean bridgeSizeOutOfRange = bridgeSize < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeSize;
        if (bridgeSizeOutOfRange) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.toString());
        }
    }

    @Override
    public InGameCommandType readMoving() {
        InGameCommandType command = InGameCommandType.find(InputReader.readLine());
        checkInGameCommand(command);
        return command;
    }

    private void checkInGameCommand(InGameCommandType command) {
        if (command == null) {
            throw new IllegalArgumentException(INVALID_IN_GAME_COMMAND.toString());
        }
    }

    @Override
    public FailMenuCommandType readGameCommand() {
        return null;
    }
}
