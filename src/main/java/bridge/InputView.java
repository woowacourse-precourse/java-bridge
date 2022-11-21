package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final ExceptionHandler exceptionHandler;

    InputView() {
        this.exceptionHandler = new ExceptionHandler();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String sizeString = Console.readLine();
        while (!exceptionHandler.checkBridgeSize(sizeString)) {
            sizeString = Console.readLine();
        }
        return Integer.parseInt(sizeString);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveString = Console.readLine();
        while (!exceptionHandler.checkMoving(moveString)) {
            moveString = Console.readLine();
        }
        return moveString;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String retryString = Console.readLine();
        while (!exceptionHandler.checkRetry(retryString)) {
            retryString = Console.readLine();
        }
        return retryString;
    }
}
