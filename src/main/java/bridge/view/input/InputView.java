package bridge.view.input;

import bridge.view.Terminal;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        Terminal.Out.printLine(InputMessage.BRIDGE_SIZE);
        return Terminal.In.readNumber();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Terminal.Out.printLine(InputMessage.MOVING);
        return Terminal.In.readMessage();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        Terminal.Out.printLine(InputMessage.GAME_COMMAND);
        return Terminal.In.readMessage();
    }
}
