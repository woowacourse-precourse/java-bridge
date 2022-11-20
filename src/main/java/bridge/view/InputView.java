package bridge.view;

import bridge.domain.BridgeMaker;
import bridge.handler.InputBridgeLengthHandler;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Order;
import org.mockito.internal.matchers.Or;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OrderView orderView = new OrderView();
    InputBridgeLengthHandler inputBridgeLengthHandler = new InputBridgeLengthHandler();
    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() {
        System.out.println(orderView.START_ORDER);
        orderView.lineSkip();
        System.out.println(orderView.INPUT_BRIDGE_LENGTH);
        inputBridgeLengthHandler.checkException(Console.readLine());
        orderView.lineSkip();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
