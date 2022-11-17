package bridge.view;

import bridge.utils.UserInputConvertor;
import bridge.utils.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.Constants.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_MESSAGE_ENTER_BRIDGE_SIZE);
        return UserInputConvertor.mapToBridgeSize(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_MESSAGE_ENTER_SPACE_TO_MOVE);
        String spaceToMove = Console.readLine();
        UserInputValidator.validateSpaceToMove(spaceToMove);
        return spaceToMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_MESSAGE_RETRY_GAME_COMMAND);
        String retryCommand = Console.readLine();
        UserInputValidator.validateGameCommand(retryCommand);
        return retryCommand;
    }
}
