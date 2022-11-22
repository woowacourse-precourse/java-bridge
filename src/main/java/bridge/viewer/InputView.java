package bridge.viewer;

import camp.nextstep.edu.missionutils.Console;

import static bridge.viewer.ErrorMessage.*;
import static bridge.viewer.GameCommand.QUIT;
import static bridge.viewer.GameCommand.RETRY;
import static bridge.viewer.MoveCommand.DOWN;
import static bridge.viewer.MoveCommand.UP;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    public static int readBridgeSize() throws IllegalArgumentException {
        String bridgeSize = Console.readLine();
        validateNumber(bridgeSize);
        System.out.println(BRIDGE_SIZE_MESSAGE);
        return Integer.parseInt(bridgeSize);
    }

    public static String readMoving() throws IllegalArgumentException {
        String movingCommand = Console.readLine();
        validateMoving(movingCommand);
        return movingCommand;
    }

    public static String readGameCommand() throws IllegalArgumentException {
        String gameCommand = Console.readLine();
        validateGame(gameCommand);
        return gameCommand;
    }

    private static void validateNumber(String bridgeSize) throws IllegalArgumentException {
        if (!bridgeSize.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException(BRIDGE_NUMBER_MESSAGE);
        }
    }

    private static void validateMoving(String command) throws IllegalArgumentException {
        if (!command.equals(UP)&&!command.equals(DOWN)) {
            throw new IllegalArgumentException(MOVING_COMMAND_ERROR);
        }
    }

    private static void validateGame(String command) throws IllegalArgumentException {
        if (!command.equals(RETRY)&&!command.equals(QUIT)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR);
        }
    }
}
