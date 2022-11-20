package bridge.view;

import bridge.handler.InputBridgeLengthHandler;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OrderView orderView = new OrderView();
    InputBridgeLengthHandler inputBridgeLengthHandler = new InputBridgeLengthHandler();
    /**
     * 다리의 길이를 입력받는다.
     *
     * @return
     */
    public String readBridgeSize() {
        System.out.println(orderView.START_ORDER);
        orderView.lineSkip();
        System.out.println(orderView.INPUT_BRIDGE_LENGTH);
        String bridgeLength = inputBridgeLengthHandler.checkException(Console.readLine());
        orderView.lineSkip();

        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveStep = Console.readLine();
        return moveStep;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
