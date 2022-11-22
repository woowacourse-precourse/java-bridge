package bridge.view;

import bridge.domain.enums.Command;
import bridge.domain.enums.Error;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int SIZE_MIN = 3;
    private static final int SIZE_MAX = 20;

    public int readBridgeSize() {
        String input = getInput("다리의 길이를 입력해주세요.");
        try {
            validateAllNumber(input);
            validateNumberRange(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = getInput("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            validateMoveCommand(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return input;
    }

    public String readGameCommand() {
        String input = getInput("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        try {
            validateGameCommand(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return input;
    }

    private String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
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
