package bridge.view;

 import bridge.domain.BridgeType;
import camp.nextstep.edu.missionutils.Console;

import static bridge.exception.InputViewExceptionMessage.*;
import static bridge.view.InputViewMessage.READ_BRIDGE_SIZE;
import static bridge.view.InputViewMessage.READ_MOVE_BOARD;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.print(READ_BRIDGE_SIZE.getMessage());
        String readBridgeSize = Console.readLine();
        validateDigit(readBridgeSize);
        int bridgeSize = parseToIntegerFrom(readBridgeSize);
        validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeType readMoving() {
        System.out.print(READ_MOVE_BOARD.getMessage());
        String readMoveBridgeType = Console.readLine();
        return BridgeType.of(readMoveBridgeType);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
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
