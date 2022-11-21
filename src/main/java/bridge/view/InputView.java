package bridge.view;

import static bridge.utils.constants.BridgeConstants.INPUT_BRIDGE_LENGTH;
import static bridge.utils.constants.BridgeConstants.INPUT_BRIDGE_MOVE_OPTION;

import bridge.utils.constants.GameConstants;
import bridge.utils.validator.BridgeValidator;
import bridge.utils.validator.GameValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        while (true) {
            try {
                System.out.println(INPUT_BRIDGE_LENGTH);
                String bridgeSize = Console.readLine();
                BridgeValidator.validSize(bridgeSize);
                return Integer.parseInt(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        while (true) {
            try {
                System.out.println(INPUT_BRIDGE_MOVE_OPTION);
                String moving = Console.readLine();
                GameValidator.validMovingOption(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        while (true) {
            try {
                System.out.println(GameConstants.RESTART_GAME_OPTION);
                String gameCommand = Console.readLine();
                GameValidator.validGameCommand(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
