package bridge.view;

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
        // TODO Bridge 길이 에러 처리
        validateBridgeInputIsBlank(userBridgeSize);
        int bridgeSize = changeStringToInt(userBridgeSize);
        return bridgeSize;
    }

    public void validateBridgeInputIsBlank(String uncheckedInput) {
        if(uncheckedInput.isBlank()) {
            throw new IllegalArgumentException(InputException.BLANK_BRIDGE_LENGTH.getExceptionMessage());
        }
    }

    public int changeStringToInt(String checkedInput) {
        return Integer.parseInt(checkedInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
