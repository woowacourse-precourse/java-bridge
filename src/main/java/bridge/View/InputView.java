package bridge.View;

import static bridge.Utils.Convertor.stringToInt;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private String readLine() {
        return Console.readLine();
    }

    private int readNumber() {
        String input = readLine();
        return stringToInt(input);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int input = readNumber();
        return 0;
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
