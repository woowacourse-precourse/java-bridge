package bridge.view;

import bridge.validation.BridgeSizeInputException;
import bridge.validation.MoveInputException;
import bridge.validation.RetryInputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(GameMessage.INPUT_BRIDGE_SIZE_MESSAGE.getGameMessage());
            String bridgeSize = Console.readLine();
            System.out.println();
            BridgeSizeInputException.validateBridgeSize(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(GameMessage.INPUT_MOVE_MESSAGE.getGameMessage());
            String upOrDown = Console.readLine();
            MoveInputException.validateMoveInput(upOrDown);
            return upOrDown;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(GameMessage.GAME_RETRY_MESSAGE.getGameMessage());
            String restartAndQuit = Console.readLine();
            RetryInputException.validateRetryInput(restartAndQuit);
            return restartAndQuit;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
