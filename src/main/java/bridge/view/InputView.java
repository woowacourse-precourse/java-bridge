package bridge.view;

import bridge.domain.BridgeGameEndType;
import bridge.domain.BridgeMoveType;
import camp.nextstep.edu.missionutils.Console;

import static bridge.exception.InputViewExceptionMessage.*;
import static bridge.view.InputViewMessage.*;

public class InputView {

    public int readBridgeSize() {
        System.out.print(START_BRIDGE_GAME.getMessage());
        System.out.print(READ_BRIDGE_SIZE.getMessage());
        String readBridgeSize = Console.readLine();
        validateDigit(readBridgeSize);
        int bridgeSize = parseToIntegerFrom(readBridgeSize);
        validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }

    public BridgeMoveType readMoving() {
        System.out.print(READ_MOVE_BOARD.getMessage());
        String readMoveType = Console.readLine();
        if (!BridgeMoveType.isMoveTypeExists(readMoveType)) {
            throw new IllegalArgumentException(READ_WRONG_MOVE_TYPE_EXCEPTION.getMessage());
        }
        return BridgeMoveType.of(readMoveType);
    }

    public BridgeGameEndType readGameCommand() {
        System.out.println(READ_SELECT_GAME_END_TYPE.getMessage());
        String readGameEndType = Console.readLine();
        if (!BridgeGameEndType.isEndTypeExists(readGameEndType)) {
            throw new IllegalArgumentException(READ_WRONG_GAME_END_TYPE_EXCEPTION.getMessage());
        }
        return BridgeGameEndType.of(readGameEndType);
    }

    private void validateDigit(String read) {
        if (!read.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(READ_BRIDGE_SIZE_NOT_DIGIT_EXCEPTION.getMessage());
        }
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (3 > bridgeSize || bridgeSize > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OVER_RANGE_EXCEPTION.getMessage());
        }
    }

    private int parseToIntegerFrom(String read) {
        return Integer.parseInt(read);
    }
}
