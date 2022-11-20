package bridge.domain.ui;

import bridge.domain.utils.Validation;
import camp.nextstep.edu.missionutils.Console;

import static bridge.domain.ui.ReservedMessage.ERROR_MESSAGE;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String response = Console.readLine();
            return Validation.validateBridgeSize(response);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE.getMsg() + e);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String response = Console.readLine();
            Validation.validateSpace(response);
            return response;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE.getMsg() + e);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String response = Console.readLine();
            Validation.validateResponseAfterFailure(response);
            return response;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE.getMsg() + e);
            return readGameCommand();
        }
    }
}
