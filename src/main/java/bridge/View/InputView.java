package bridge.View;

import static bridge.Utils.Convertor.stringToInt;

import bridge.Utils.Validation.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Validation validation;

    public InputView() {
        validation = new Validation();
    }

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
        validation.isBridgeSize(input);
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = readLine();
        validation.isRightMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = readLine();
        validation.isGameCommand(input);
        return input;
    }
}
