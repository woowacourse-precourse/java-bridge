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
        String size;
        String validSize;
        do {
            size = Console.readLine();
            validSize = InputValidator.checkBridgeSize(size);
        }while(validSize.equals("error"));

        return validSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String moving;
        String validMoving;
        do {
            moving = Console.readLine();
            validMoving = InputValidator.controlMovingInput(moving);
        }while(validMoving.equals("error"));

        return validMoving;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String retryInput;
        String validRetryInput;
        do {
            retryInput = Console.readLine();
            validRetryInput = InputValidator.controlRetryInput(retryInput);
        }while(validRetryInput.equals("error"));

        return validRetryInput;
    }
}
