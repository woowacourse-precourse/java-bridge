package bridge;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import exception.ExceptionMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private CustomException customException = new CustomException();
    private OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printMessage("다리의 길이를 입력해주세요.");
        try {
            int input = Integer.parseInt(Console.readLine());
            if (customException.checkBridgeSize(input)) return input;
            return readBridgeSize();
        } catch (NumberFormatException e) {
            outputView.printExceptionMessage(ExceptionMessage.INVALID_INPUT);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        return input;
    }
}
