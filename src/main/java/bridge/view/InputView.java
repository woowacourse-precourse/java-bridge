package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.InputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userBridgeSize = Console.readLine();
        validateBridgeSizeIsBlank(userBridgeSize);
        validateBridgeSizeFormat(userBridgeSize);
        validateBridgeSizeRange(userBridgeSize);
        int bridgeSize = changeStringToInt(userBridgeSize);
        return bridgeSize;
    }

    public void validateBridgeSizeIsBlank(String uncheckedInput) {
        if(uncheckedInput.isBlank()) {
            throw new IllegalArgumentException(InputException.BLANK_BRIDGE_LENGTH.getExceptionMessage());
        }
    }

    public void validateBridgeSizeFormat(String uncheckedInput) {
        try {
            changeStringToInt(uncheckedInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputException.NOT_NUMBER_BRIDGE_LENGTH.getExceptionMessage());
        }
    }

    private int changeStringToInt(String checkedInput) {
        return Integer.parseInt(checkedInput);
    }

    public void validateBridgeSizeRange(String uncheckedInput) {
        int bridgeSize = changeStringToInt(uncheckedInput);
        if(bridgeSize < BridgeSize.SIZE_MINIMUM.getSize() || bridgeSize > BridgeSize.SIZE_MAXIMUM.getSize()) {
            throw new IllegalArgumentException(InputException.OUT_OF_RANGE_BRIDGE_LENGTH.getExceptionMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userMove = Console.readLine();
        validateBlankMove(userMove);
        return null;
    }

    public void validateBlankMove(String uncheckedInput) {
        if(uncheckedInput.isBlank()) {
            throw new IllegalArgumentException(InputException.BLANK_PLAYER_MOVE.getExceptionMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
