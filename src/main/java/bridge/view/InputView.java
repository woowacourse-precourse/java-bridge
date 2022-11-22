package bridge.view;

import bridge.domain.enums.Command;
import bridge.domain.enums.Error;
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
            String input = getInput("다리의 길이를 입력해주세요.");
            validateAllNumber(input);
            validateNumberRange(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            String input = getInput("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            validateMoveCommand(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            String input = getInput("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            validateGameCommand(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private String getInput(String message) {
        try {
            System.out.println(message);
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }
    }

    private void validateAllNumber(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException(Error.ONLY_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < SIZE_MIN || number > SIZE_MAX) {
                throw new IllegalArgumentException(Error.NUMBER_RANGE_OVER.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }
    }

    private void validateMoveCommand(String input) {
        if (!input.equals(Command.UP.getCommand()) && !input.equals(Command.DOWN.getCommand())) {
            throw new IllegalArgumentException(Error.INVALID_COMMAND.getMessage());
        }
    }

    private void validateGameCommand(String input) {
        if (!input.equals(Command.RETRY.getCommand()) && !input.equals(Command.QUIT.getCommand())) {
            throw new IllegalArgumentException(Error.INVALID_COMMAND.getMessage());
        }
    }
}
