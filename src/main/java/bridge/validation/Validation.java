package bridge.validation;

import static bridge.command.MoveCommand.*;
import static bridge.util.Constant.*;

import bridge.command.MoveCommand;

public class Validation {

    public static void checkBridgeLengthConsistOfNum(String bridgeLength){
        if(!bridgeLength.matches(BRIDGE_LENGTH_REGEX)){
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_LENGTH_CONSIST_OF_NUM);
        }
    }

    // 다리의 길이 입력값이 3이상 20이하인지 검증하는 기능
    public static void checkBridgeLengthRange3To20(String bridgeLengthInput) {
        int bridgeLength = Integer.parseInt(bridgeLengthInput);
        if (!(BRIDGE_LENGTH_MIN <= bridgeLength && bridgeLength <= BRIDGE_LENGTH_MAX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_LENGTH_RANGE_3_TO_20);
        }
    }

    // 다리를 이동할 때 입력값이 U 혹은 D인지 검증하는 기능
    public static void checkMoveCommand(String moveInput) {
        if (!(moveInput.equals(MoveUp.getMoveDirection()) ||
            moveInput.equals(MoveDown.getMoveDirection()))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_MOVE_COMMAND_INPUT_ERROR);
        }
    }
}
