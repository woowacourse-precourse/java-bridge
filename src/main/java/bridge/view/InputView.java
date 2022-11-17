package bridge.view;

import bridge.constant.Messages;
import bridge.domain.BridgeSize;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public BridgeSize readBridgeSize() {
        System.out.println(Messages.BRIDGE_SIZE_INPUT_MESSAGE);
        return new BridgeSize(Console.readLine());
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
