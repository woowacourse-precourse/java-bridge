package bridge.view;

import static bridge.Validator.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String length = Console.readLine();
        try {
            int size = validateIsDigit(length);
            validateSizeRange(size);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            readBridgeSize();
        }
        return Integer.parseInt(length);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingValue = Console.readLine();
        try {
            movingValue = validateIsCorrectValue(Console.readLine());
        } catch (IllegalArgumentException e) {
            e.getMessage();
            readMoving();
        }
        return movingValue;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return Console.readLine();
    }

}
