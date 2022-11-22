package bridge.view;

import bridge.type.BridgeType;
import bridge.type.RestartType;
import bridge.util.Message;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_RANGE_MAX = 20;
    private static final int BRIDGE_RANGE_MIN = 3;
    OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printMessage(Message.BRIDGE_SIZE);
        String sizeInput = Console.readLine();
        outputView.enterLine();
        try {
            validateBridgeSizeRange(Integer.parseInt(sizeInput));
            return Integer.parseInt(sizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NOT_NUMBER.getMessage());
        }
    }

    public void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize > BRIDGE_RANGE_MAX || bridgeSize < BRIDGE_RANGE_MIN) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_RANGE.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMessage(Message.MOVING_CHOOSE);
        String userMove = Console.readLine();
        if (!(userMove.equals(BridgeType.UP.getStringCode()) || userMove.equals(BridgeType.DOWN.getStringCode()))) {
            throw new IllegalArgumentException(Message.ERROR_MOVE.getMessage());
        }
        return userMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printMessage(Message.REGAME);
        String userInput = Console.readLine();
        if (!(userInput.equals(RestartType.QUIT.getCommands()) || userInput.equals(
                RestartType.RESTART.getCommands()))) {
            throw new IllegalArgumentException(Message.ERROR_REGAME.getMessage());
        }
        return userInput;
    }

}
