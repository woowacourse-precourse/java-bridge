package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.NumberValidator.validateRange;
import static bridge.validator.TextValidator.validateMoveWay;
import static bridge.validator.TextValidator.validateRetry;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        OutputView.printBridgeSizeInputMessage();
        try {
            String bridgeSize = Console.readLine();
            int size = validateRange(bridgeSize);
            System.out.println(bridgeSize);
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.printMoveInputMessage();
        try {
            String moveWay = Console.readLine();
            validateMoveWay(moveWay);
            System.out.println(moveWay);
            return moveWay;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printAskRetryMessage();
        String retry = Console.readLine();

        validateRetry(retry);
        System.out.println(retry);
        return retry;
    }
}
