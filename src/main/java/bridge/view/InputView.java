package bridge.view;

import bridge.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import static bridge.constants.InputMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE.getMessage());
        String input = Console.readLine();
        InputValidation.validateReadBridgeSize(input);
        int bridgeSize = Integer.parseInt(input);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(READ_MOVING_MESSAGE.getMessage());
        String moving = Console.readLine();
        InputValidation.validateReadMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(READ_GAME_COMMAND_MESSAGE.getMessage());
        String gameCommand = Console.readLine();
        InputValidation.validateReadGameCommand(gameCommand);
        return gameCommand;
    }
}
