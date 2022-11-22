package bridge.view;

import bridge.constant.InputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(InputMessage.INPUT_BRIDGE_LENGTH_MESSAGE.getMessage());
        return Console.readLine();
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
