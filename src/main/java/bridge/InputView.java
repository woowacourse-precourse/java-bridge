package bridge;

import camp.nextstep.edu.missionutils.Console;
import data.InputForm;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        InputForm.INPUT_BRIDGE_LENGTH.printMessage();
        String inputLength = Console.readLine();
        ExceptionHandler.checkNumeric(inputLength);
        int length = Integer.parseInt(inputLength);
        ExceptionHandler.checkLengthRange(length);
        return length;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        InputForm.INPUT_USER_MOVE.printMessage();
        String inputMove = Console.readLine();
        System.out.println(inputMove);
        ExceptionHandler.checkUorD(inputMove);
        return inputMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        InputForm.INPUT_RESTART.printMessage();
        String inputRestart = Console.readLine();
        System.out.println(inputRestart);
        ExceptionHandler.checkRorQ(inputRestart);
        return inputRestart;
    }
}
