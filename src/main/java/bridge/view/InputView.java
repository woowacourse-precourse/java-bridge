package bridge.view;

import bridge.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Validation validation;

    public InputView() {
        validation = new Validation();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String number = Console.readLine();
        int size = 0;

        if (validation.isInteger(number)) {
            size = Integer.parseInt(number);
        }

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        validation.validateInputPosition(moving);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String retryCommand = Console.readLine();
        validation.validateInputRetry(retryCommand);

        return retryCommand;
    }
}
