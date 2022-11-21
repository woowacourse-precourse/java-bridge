package bridge.view;

import bridge.config.ErrorMessageConstant;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.IS_NOT_NUMBER_FORMAT);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String input = Console.readLine();
        validationCommandByGroup(input, CommandGroup.MOVE);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validationCommandByGroup(input, CommandGroup.GAME_CONTROL);
        return input;
    }

    private static void validationCommandByGroup(String input, CommandGroup commandGroup) throws IllegalArgumentException {
        try {
            CommandType commandType = CommandType.of(input);
            if (CommandGroup.findByCommandType(commandType) == commandGroup) {
                return;
            }
            throw new IllegalArgumentException(ErrorMessageConstant.INVALID_COMMAND_IN_STATUS);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
