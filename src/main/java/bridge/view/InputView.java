package bridge.view;

import bridge.view.printer.InputPrinter;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final InputPrinter inputPrinter;

    public InputView() {
        inputPrinter = new InputPrinter();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        inputPrinter.printInputBridgeSizeMessage();
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        inputPrinter.printInputUserMoveCommandMessage();
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        inputPrinter.printInputGameCommandMessage();
        return Console.readLine();
    }
}
