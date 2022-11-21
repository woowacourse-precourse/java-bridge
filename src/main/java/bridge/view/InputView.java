package bridge.view;

import bridge.constant.IOMessage;
import bridge.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int readBridgeSize() {
        System.out.println(IOMessage.BRIDGE_SIZE);
        int size = InputValidator.isBridgeSizeNumeric(Console.readLine());
        System.out.println();
        return size;
    }
    public String readMoving() {
        System.out.println(IOMessage.UP_OR_DOWN);
        return Console.readLine();
    }
    public String readGameCommand() {
        System.out.println(IOMessage.RETRY_OR_EXIT);
        return Console.readLine();
    }
}
