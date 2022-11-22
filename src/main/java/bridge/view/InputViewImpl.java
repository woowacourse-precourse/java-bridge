package bridge.view;

import static bridge.type.CommonConstantType.*;
import static bridge.type.ErrorMessageUserType.*;
import static bridge.type.InputMessageType.*;

import bridge.type.FailMenuCommandType;
import bridge.type.InGameCommandType;
import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

    @Override
    public int readBridgeSize() {
        System.out.println(ASK_BRINDGE_SIZE_MESSAGE);
        String input = Console.readLine();
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
    public InGameCommandType readInGameCommand() {
        System.out.println(ASK_IN_GAME_COMMAND_MESSAGE);
        InGameCommandType command = InGameCommandType.find(Console.readLine());
        checkInGameCommand(command);
        return command;
    }

    private void checkInGameCommand(InGameCommandType command) {
        if (command == null) {
            throw new IllegalArgumentException(INVALID_IN_GAME_COMMAND.toString());
        }
    }

    @Override
    public FailMenuCommandType readFailMenuCommand() {
        System.out.println(ASK_FAIL_MENU_COMMAND_MESSAGE);
        FailMenuCommandType command = FailMenuCommandType.find(Console.readLine());
        checkFailMenuCommand(command);
        return command;
    }

    private void checkFailMenuCommand(FailMenuCommandType command) {
        if (command == null) {
            throw new IllegalArgumentException(INVALID_FAIL_MENU_COMMAND.toString());
        }
    }
}
