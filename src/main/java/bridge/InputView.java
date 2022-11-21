package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            ExceptionMessage.INPUT_WRONG_BRIDGE_LENGTH_MESSAGE.throwException();
        }

        return 0;
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
