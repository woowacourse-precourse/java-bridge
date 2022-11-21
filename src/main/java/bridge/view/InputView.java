package bridge.view;

import bridge.domain.bridge.BridgeBlock;
import bridge.resource.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        return getInput();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return getInput();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return getInput();
    }

    private String getInput() {
        return Console.readLine();
    }

    private void validateNumeric(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue());
        }
    }

    private void validateSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BETWEEN_3_AND_20_MESSAGE.getValue());
        }
    }
}
