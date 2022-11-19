package bridge.view;

import bridge.domain.Command;
import bridge.domain.Error;
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
            System.out.println("다리의 길이를 입력해주세요.");
            String input = Console.readLine();
            validateAllNumber(input);
            validateNumberRange(input);
            return Integer.parseInt(input);
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }
    }

    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = Console.readLine();
            validateMoveCommand(input);
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }
    }

    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String input = Console.readLine();
            validateGameCommand(input);
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }
    }

    public void validateAllNumber(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException(Error.ONLY_NUMBER.getMessage());
        }
    }

    public void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < SIZE_MIN || number > SIZE_MAX) {
            throw new IllegalArgumentException(Error.NUMBER_RANGE_OVER.getMessage());
        }
    }

    public void validateMoveCommand(String input) {
        if (!input.equals(Command.UP.getCommand()) && !input.equals(Command.DOWN.getCommand())) {
            throw new IllegalArgumentException(Error.INVALID_COMMAND.getMessage());
        }
    }

    public void validateGameCommand(String input) {
        if (!input.equals(Command.RETRY.getCommand()) && !input.equals(Command.QUIT.getCommand())) {
            throw new IllegalArgumentException(Error.INVALID_COMMAND.getMessage());
        }
    }
}
