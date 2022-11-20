package bridge.view;

import bridge.constants.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String REGULAR_PATTERN = "[^0-9]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeInput = Console.readLine();
        int bridgeLength = Integer.parseInt(bridgeInput);
        bridgeSizeVerification(bridgeLength);
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return Console.readLine();
    }

    public void bridgeSizeVerification(int bridgeLength) {
        validateNull(bridgeLength);
        validateBetween(bridgeLength);
        validateNumber(bridgeLength);
    }

    public void validateNull(int bridgeLength) {
        String bridge = String.valueOf(bridgeLength);
        if (bridge.equals("")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INPUT);
        }
    }

    // 3 이상 20 이하
    public void validateBetween(int bridgeLength) {
        if (!(bridgeLength >= 3 && bridgeLength <= 20)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_BETWEEN);
        }
    }

    public void validateNumber(int bridgeLength) {
        String bridge = String.valueOf(bridgeLength);
        if (!(bridge.equals(REGULAR_PATTERN))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_CHARACTERS);
        }
    }
}


