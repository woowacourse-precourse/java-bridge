package bridge.view;

import bridge.domain.Command;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int SIZE_MIN = 3;
    private static final int SIZE_MAX = 20;

    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            validateAllNumber(input);
            validateNumberRange(input);
            return Integer.parseInt(input);
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public String readMoving() {
        try {
            String input = Console.readLine();
            validateMoveCommand(input);
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    public String readGameCommand() {
        try {
            String input = Console.readLine();
            validateGameCommand(input);
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateAllNumber(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < SIZE_MIN || number > SIZE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    public void validateMoveCommand(String input) {
        if (!input.equals(Command.UP.getCommand()) && !input.equals(Command.DOWN.getCommand())) {
            throw new IllegalArgumentException();
        }
    }

    public void validateGameCommand(String input) {
        if (!input.equals(Command.RETRY.getCommand()) && !input.equals(Command.QUIT.getCommand())) {
            throw new IllegalArgumentException();
        }
    }
}
