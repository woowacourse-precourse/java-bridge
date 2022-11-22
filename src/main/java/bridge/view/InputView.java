package bridge.view;

import static bridge.rule.BridgeSizeRange.isBridgeSizeOutOfRange;
import static bridge.rule.CommandOption.isCorrectCommand;
import static bridge.rule.MovingOption.isCorrectMoving;

import bridge.exception.GameCommandNotAllowedException;
import bridge.exception.InputNotNumberException;
import bridge.exception.MovingOptionNotAllowedException;
import bridge.exception.NotInputGameCommandException;
import bridge.exception.NotInputMovingOptionException;
import bridge.exception.NumberOutOfRangeException;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

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

    public String readMoving() {
        try {
            String option = Console.readLine();
            validateMovingOption(option);
            return option;
        } catch (NoSuchElementException e) {
            throw new NotInputMovingOptionException();
        }
    }

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

    private void validateMovingOption(String moving) {
        validateOptionNotInput(moving);
        validateMovingAllowedOption(moving);
    }

    private void validateOptionNotInput(String moving) {
        if (moving.equals("")) {
            throw new NotInputMovingOptionException();
        }
    }

    private void validateMovingAllowedOption(String moving) {
        if (!isCorrectMoving(moving)) {
            throw new MovingOptionNotAllowedException();
        }
    }

    private void validateGameCommand(String command) {
        validateCommandAllowedOption(command);
    }

    private void validateCommandAllowedOption(String command) {
        if (!isCorrectCommand(command)) {
            throw new GameCommandNotAllowedException();
        }
    }
}
