package bridge;

import camp.nextstep.edu.missionutils.Console;
import message.InputMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MINIMUM_NUMBER = 3;

    private static final int MAXIMUM_NUMBER = 20;

    public InputView() {

    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            InputMessage.print(InputMessage.INPUT_BRIDGE_LENGTH);
            int number = toInt(Console.readLine());
            validateNumberRange(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            throw e;
        }
    }

    public int toInt(String strNumber) {
        validateInt(strNumber);
        return Integer.parseInt(strNumber);
    }


    private void validateNumberRange(int number) {
        if (MINIMUM_NUMBER > number || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 3과 20사이의 숫자가 아닙니다");
        }
    }

    private void validateInt(String word) {
        if (!word.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력했습니다");
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
        return null;
    }
}
