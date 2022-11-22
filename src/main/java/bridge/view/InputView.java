package bridge.view;

import bridge.constant.IOMessage;
import bridge.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    InputValidator inputValidator = new InputValidator();
    public int readBridgeSize() {
        try {
            return tryReadingSize();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + '\n');
            return readBridgeSize();
        }
    }
    private int tryReadingSize() {
        System.out.println(IOMessage.BRIDGE_SIZE);
        int size = inputValidator.isBridgeSizeNumeric(Console.readLine());
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
