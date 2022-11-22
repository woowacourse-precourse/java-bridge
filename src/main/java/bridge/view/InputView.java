package bridge.view;

import bridge.util.GameInputValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.enums.InputMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final GameInputValidator validator;

    public InputView() {
        validator = new GameInputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                String number = inputBridgeNumber();
                return validator.parseNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String moving = inputMoving();
                return validator.isValidMovingMessage(moving);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String retry = inputRetry();
                return validator.isValidRetryMessage(retry);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    String inputBridgeNumber() {
        System.out.println(INIT_LENGTH_MESSAGE.getMessage());
        return Console.readLine();
    }

    String inputMoving() {
        System.out.println(INIT_MOVE_MESSAGE.getMessage());
        return Console.readLine();
    }

    String inputRetry() {
        System.out.println(INIT_RETRY_MESSAGE.getMessage());
        return Console.readLine();
    }
}
