package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        OutputView.printRequestBridgeSize();
        int size = ValidCheck.bridgeSize(Console.readLine());
        return size;
    }

    public static int readBridgeSizeUntilSuccess() {
        while (true) {
            try {
                return readBridgeSize();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.printRequestUpOrDown();
        String direction = Console.readLine();
        ValidCheck.upOrDown(direction);
        return direction;
    }

    public static String readMovingUntilSuccess() {
        while (true) {
            try {
                return readMoving();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printRequestRetryOrQuit();
        String retryOrQuit = Console.readLine();
        ValidCheck.retryOrQuit(retryOrQuit);
        return retryOrQuit;
    }

    public static String readGameCommandUntilSuccess() {
        while (true) {
            try {
                return readGameCommand();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
