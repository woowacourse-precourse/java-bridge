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
    public CommandType readMoving() throws IllegalArgumentException {
        String input = Console.readLine();
        return validatedCommandByGroup(input, CommandGroup.MOVE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public CommandType readGameCommand() throws IllegalArgumentException {
        String input = Console.readLine();
        return validatedCommandByGroup(input, CommandGroup.GAME_CONTROL);
    }

    private static CommandType validatedCommandByGroup(String input, CommandGroup commandGroup) throws IllegalArgumentException {
        try {
            CommandType commandType = CommandType.of(input);
            if (CommandGroup.findByCommandType(commandType) == commandGroup) {
                return commandType;
            }
            throw new IllegalArgumentException(ErrorMessageConstant.INVALID_COMMAND_IN_STATUS);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
