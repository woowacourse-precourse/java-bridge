package bridge.view;

import bridge.utils.validator.BridgeSizeValidator;
import bridge.utils.validator.GameCommandValidator;
import bridge.utils.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.ViewMessages.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                return inputBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBridgeSize() {
        System.out.println(BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        printNewLine();
        BridgeSizeValidator.validate(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                return inputMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputMoving() {
        System.out.println(MOVING);
        String moving = Console.readLine();
        MovingValidator.validate(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                return inputGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputGameCommand() {
        System.out.println(GAME_COMMAND);
        String gameCommand = Console.readLine();
        GameCommandValidator.validate(gameCommand);
        return gameCommand;
    }

    public void printNewLine() {
        System.out.println();
    }
}
