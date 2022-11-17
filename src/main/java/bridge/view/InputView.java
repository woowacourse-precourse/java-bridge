package bridge.view;

import bridge.utils.UserInputConvertor;
import bridge.utils.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.Constants.*;

public class InputView {

    public static int readBridgeSize() {
        System.out.println(INPUT_MESSAGE_ENTER_BRIDGE_SIZE);
        return UserInputConvertor.mapToBridgeSize(Console.readLine());
    }

    public static String readMoving() {
        System.out.println(INPUT_MESSAGE_ENTER_SPACE_TO_MOVE);
        String spaceToMove = Console.readLine();
        UserInputValidator.validateSpaceToMove(spaceToMove);
        return spaceToMove;
    }

    public static String readGameCommand() {
        System.out.println(INPUT_MESSAGE_RETRY_GAME_COMMAND);
        String retryCommand = Console.readLine();
        UserInputValidator.validateGameCommand(retryCommand);
        return retryCommand;
    }
}
