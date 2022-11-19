package bridge.view;

import bridge.Validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        System.out.println("다리 길이를 입력해 주세요.");
        String size = Console.readLine();
        String validSize = InputValidator.checkBridgeSize(size);
        return validSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String moving = Console.readLine();
        InputValidator.checkMoving(moving);
        return moving;
    }

    public static String readRetry() {
        String retryInput = Console.readLine();
        InputValidator.checkRetry(retryInput);
        return retryInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
