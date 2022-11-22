package bridge.view.input;

import bridge.view.console.Printer;
import bridge.view.console.Reader;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NEW_LINE = "\n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize;

        Printer.print(NEW_LINE);
        Printer.printLine(InputMessage.BRIDGE_SIZE);
        bridgeSize = Reader.readNumber();
        return InputValidator.validateBridgeSize(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving;

        Printer.print(NEW_LINE);
        Printer.printLine(InputMessage.MOVING);
        moving = Reader.readString();
        return InputValidator.validateMoving(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand;

        Printer.printLine(InputMessage.GAME_COMMAND);
        gameCommand = Reader.readString();
        return InputValidator.validateGameCommand(gameCommand);
    }
}
