package bridge.views;

import static bridge.messages.InputMessage.INPUT_BRIDGE_BLOCK;
import static bridge.messages.InputMessage.INPUT_BRIDGE_LENGTH;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        return readLine();
    }

    public String readBlock() {
        System.out.println(INPUT_BRIDGE_BLOCK);
        return readLine();
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


    private String readLine() {
        return Console.readLine();
    }
}
