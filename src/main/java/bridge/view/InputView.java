package bridge.view;

import bridge.config.ErrorMessageConstant;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 사용자로부터 다리의 길이를 입력 받는다.
     * @return 다리의 길이
     * @throws IllegalArgumentException 숫자 형태의 입력이 아닐 경우 예외 발생
     */
    public int readBridgeSize() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.IS_NOT_NUMBER_FORMAT);
        }
    }

    /**
     * 사용자가 이동할 방향을 입력받는다.
     * @return 방향 명령어
     * @throws IllegalArgumentException 명령어를 찾을 수 없거나, 현재 사용할 수 있는 명령어가 아닌 경우 예외 발생
     */
    public CommandType readMoving() throws IllegalArgumentException {
        String input = Console.readLine();
        return validatedCommandByGroup(input, CommandGroup.MOVE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     * @return 게임 제어 명령어
     * @throws IllegalArgumentException 명령어를 찾을 수 없거나, 현재 사용할 수 있는 명령어가 아닌 경우 예외 발생
     */
    public CommandType readGameCommand() throws IllegalArgumentException {
        String input = Console.readLine();
        return validatedCommandByGroup(input, CommandGroup.GAME_CONTROL);
    }

    /**
     * 현재 사용 가능한 명령어인지 검증한다.
     * @param input 사용자 입력
     * @param commandGroup 허용하는 명령어 그룹
     * @return 명령어
     * @throws IllegalArgumentException 명령어를 찾을 수 없거나, 현재 사용할 수 있는 명령어가 아닌 경우 예외 발생
     */
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
