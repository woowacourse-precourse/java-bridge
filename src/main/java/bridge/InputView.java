package bridge;

import bridge.enums.InputViewMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    InputException inputException = new InputException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println(InputViewMessage.READ_BRIDGE_SIZE_MESSAGE.getMessage());
                String inputBridgeLength = Console.readLine();
                inputException.validateReadBridgeSize(inputBridgeLength);
                return Integer.parseInt(inputBridgeLength);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                continue;
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println(InputViewMessage.READ_MOVING_MESSAGE.getMessage());
                String inputMovingPosition = Console.readLine();
                inputException.validateReadMoving(inputMovingPosition);
                return inputMovingPosition;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                continue;
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println(InputViewMessage.READ_GAME_COMMAND_MESSAGE.getMessage());
                String inputCommand = Console.readLine();
                inputException.validateReadGameCommand(inputCommand);
                return inputCommand;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                continue;
            }
        }
    }
}
