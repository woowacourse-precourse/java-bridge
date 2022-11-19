package bridge.View;

import bridge.Utils.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * (추가) 올바르지 않을경우(Exception) 기본적으로 메소드를 재귀한다.
 */
public class InputView extends OutputView {

    private final Validation validate;

    public InputView() {
        validate = new Validation();
        start();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printGetUserBridgeSize();
        String inputSize = Console.readLine();

        try {
            return validate.checkSizeReturnInt(inputSize);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printGetUserDirection();
        String direction = Console.readLine();

        try {
            validate.checkProperDirection(direction);
            return direction;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        printGetUserRetry();
        String retryInput = Console.readLine();

        try {
            validate.checkGameCommandInput(retryInput);
            return retryInput;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
