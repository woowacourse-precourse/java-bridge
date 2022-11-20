package bridge.view;

import static bridge.utils.constants.BridgeConstants.*;

import bridge.utils.constants.GameConstants;
import bridge.utils.validator.BridgeValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        String bridgeSize = Console.readLine();
        BridgeValidator.validSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_BRIDGE_MOVE_OPTION);
        String moving = Console.readLine();
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(GameConstants.RESTART_GAME_OPTION);
        String gameCommand = Console.readLine();
        return gameCommand;
    }
}
