package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String inputSize = Console.readLine();
        InputViewValidate.inputSizeValidate(inputSize);
        int size = Integer.parseInt(inputSize);
        InputViewValidate.sizeValidate(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputMove = Console.readLine();
        InputViewValidate.inputMoveValidate(inputMove);
        return inputMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String inputCommand = Console.readLine();
        InputViewValidate.inputCommandValidate(inputCommand);
        return inputCommand;
    }
}
