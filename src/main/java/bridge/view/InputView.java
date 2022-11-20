package bridge.view;

import bridge.BridgeType;
import bridge.util.Message;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printMessage(Message.BRIDGE_SIZE);
        String sizeInput = Console.readLine();
        System.out.println();
        try {
            return Integer.parseInt(sizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NOT_NUMBER.getMessage());
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
        return null;
    }
}
