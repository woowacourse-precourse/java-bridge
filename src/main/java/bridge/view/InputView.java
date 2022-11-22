package bridge.view;

import bridge.model.constant.BridgeConstant;
import bridge.model.constant.BridgeSpace;
import bridge.view.constant.ErrorMessage;
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
            int size = Integer.parseInt(Console.readLine());
            validateBridgeSize(size);
            return size;
        } catch (IllegalArgumentException exception) {
            System.out.println(ErrorMessage.INVALID_BRIDGE_SIZE);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String moving = Console.readLine();
            validateMoving(moving);
            return moving;
        } catch (IllegalArgumentException exception) {
            System.out.println(ErrorMessage.INVALID_BRIDGE_SPACE);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String gameCommand = Console.readLine();
            validateGameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException exception) {
            System.out.println(ErrorMessage.INVALID_BRIDGE_GAME_RETRY);
            return readGameCommand();
        }
    }

    private void validateBridgeSize(int size) {
        if (size < BridgeConstant.BRIDGE_SIZE_MIN || size > BridgeConstant.BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoving(String moving) {
        if (!moving.equals(BridgeSpace.UP.getValue()) && !moving.equals(BridgeSpace.DOWN.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(BridgeConstant.RESTART) && !gameCommand.equals(BridgeConstant.QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
