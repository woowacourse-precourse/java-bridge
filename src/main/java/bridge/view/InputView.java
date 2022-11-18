package bridge.view;

import static bridge.rule.BridgeSizeRange.isBridgeSizeOutOfRange;

import bridge.exception.InputNotNumberException;
import bridge.exception.NumberOutOfRangeException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            int number = Integer.parseInt(input);

            validateBridgeSize(number);

            return number;
        } catch (NumberFormatException e){
            throw new InputNotNumberException();
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

    private void validateBridgeSize(int number){
        validateSizeOutOfRange(number);
    }

    private void validateSizeOutOfRange(int number){
        if(isBridgeSizeOutOfRange(number)){
            throw new NumberOutOfRangeException();
        }
    }
}
