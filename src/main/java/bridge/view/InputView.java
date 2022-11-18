package bridge.view;

import static bridge.rule.BridgeSizeRange.isBridgeSizeOutOfRange;

import bridge.exception.InputNotNumberException;
import bridge.exception.MovingOptionIsNullException;
import bridge.exception.MovingOptionNotAllowedException;
import bridge.exception.NumberOutOfRangeException;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

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
        } catch (NumberFormatException e) {
            throw new InputNotNumberException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String option = Console.readLine();
            validateMovingOption(option);
            return option;
        } catch (NoSuchElementException e){
            throw new MovingOptionIsNullException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateBridgeSize(int number) {
        validateSizeOutOfRange(number);
    }

    private void validateSizeOutOfRange(int number) {
        if (isBridgeSizeOutOfRange(number)) {
            throw new NumberOutOfRangeException();
        }
    }

    private void validateMovingOption(String option) {
        validateOptionIsNull(option);
        validateMovingAllowedOption(option);
    }

    private void validateOptionIsNull(String option) {
        if (option.equals("")) {
            throw new MovingOptionIsNullException();
        }
    }

    private void validateMovingAllowedOption(String option) {
        if (!(option.equals("U") || option.equals("D"))) {
            throw new MovingOptionNotAllowedException();
        }
    }
}
