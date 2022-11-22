package bridge.view;

import bridge.controller.ExceptionController;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final OutputView outputView = new OutputView();
    private final ExceptionController exception = new ExceptionController();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            String input = readLine();
            try {
                exception.checkBridgeSize(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException);
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readChoice() {
        while (true) {
            String input = readLine();
            try {
                exception.checkMoving(input);
                return input;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException);
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readRetryCommand() {
        while (true) {
            try {
                String input = readLine();
                exception.checkRetryCommand(input);
                return input;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException);
            }
        }
    }
}
