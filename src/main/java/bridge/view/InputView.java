package bridge.view;

import static bridge.rule.BridgeSizeRange.isBridgeSizeOutOfRange;

import bridge.exception.GameCommandNotAllowedException;
import bridge.exception.InputNotNumberException;
import bridge.exception.MovingOptionNotAllowedException;
import bridge.exception.NotInputGameCommandException;
import bridge.exception.NotInputMovingOptionException;
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
        } catch (NoSuchElementException e) {
            throw new NotInputMovingOptionException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String command = Console.readLine();
            validateGameCommand(command);
            return command;
        } catch (NoSuchElementException e) {
            throw new NotInputGameCommandException();
        }
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
        validateOptionNotInput(option);
        validateMovingAllowedOption(option);
    }

    private void validateOptionNotInput(String option) {
        if (option.equals("")) {
            throw new NotInputMovingOptionException();
        }
    }

    private void validateMovingAllowedOption(String option) {
        if (!(option.equals("U") || option.equals("D"))) {
            throw new MovingOptionNotAllowedException();
        }
    }

    private void validateGameCommand(String command) {
        validateCommandAllowedOption(command);
    }

    private void validateCommandAllowedOption(String command) {
        if (!(command.equals("Q") || command.equals("R"))) {
            throw new GameCommandNotAllowedException();
        }
    }
}
