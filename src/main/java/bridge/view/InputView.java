package bridge.view;

import bridge.utils.SizeInputParser;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        printForInputMessage(Messages.SCAN_BRIDGE_SIZE);
        
        return SizeInputParser.parseSize(getInput());
    }

    public String readMoving() {
        printForInputMessage(Messages.SCAN_MOVING_COMMAND);

        return getInput();
    }

    public String readGameCommand() {
        printForInputMessage(Messages.SCAN_GAME_COMMAND);

        return getInput();
    }

    public void printForInputMessage(Messages message) {
        System.out.println(message.getMessage());
    }

    public String getInput() {
        return Console.readLine();
    }

}
