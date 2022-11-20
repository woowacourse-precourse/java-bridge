package bridge.view;

import bridge.domain.SizeOfBridge;
import bridge.utils.BridgeSizeInputParser;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static SizeOfBridge readBridgeSize() {
        try {
            String size = bridgeSizeInput();

            return BridgeSizeInputParser.parseSizeOfBridge(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
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

    public static String bridgeSizeInput() {
        printForInputMessage(Messages.SCAN_BRIDGE_SIZE);

        return getInput();
    }

    public static void printForInputMessage(Messages message) {
        System.out.println(message.getMessage());
    }

    public static String getInput() {
        return Console.readLine();
    }

}
