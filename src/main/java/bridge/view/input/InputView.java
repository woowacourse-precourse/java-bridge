package bridge.view.input;

import bridge.view.console.Printer;
import bridge.view.console.Reader;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        Printer.printLine(InputMessage.BRIDGE_SIZE);
        return Reader.readNumber();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Printer.printLine(InputMessage.MOVING);
        return Reader.readString();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        Printer.printLine(InputMessage.GAME_COMMAND);
        return Reader.readString();
    }
}
