package bridge;

import bridge.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String REQUEST_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(REQUEST_BRIDGE_LENGTH);
        String lengthInput = Console.readLine();

        try {
            InputValidator.intInputValidation(lengthInput);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }

        return Integer.parseInt(lengthInput);
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
