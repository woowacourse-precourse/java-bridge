package bridge.view;

import bridge.util.ConstantMessage;
import bridge.util.Exceptions;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String readLine = null;
        while (true) {
            readLine = Exceptions.validateBridgeLength(Console.readLine());
            if (!readLine.equals(ConstantMessage.BRIDGE_LENGTH_ERROR_MESSAGE)) {
                break;
            }
            System.out.println(readLine);
        }
        return Integer.parseInt(readLine);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String readLine;
        while (true) {
            readLine = Console.readLine();
            if (readLine.equals(OutputView.printBridgeLengthErrorMessage(readLine))) {
                break;
            }
        }
        return readLine;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
