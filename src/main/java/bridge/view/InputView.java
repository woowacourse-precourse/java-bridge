package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static bridge.utils.Validation.validateGameCommand;
import static bridge.utils.Validation.validateBridgeSize;
import static bridge.utils.Validation.validateMoving;

public class InputView {

    public int readBridgeSize() {
        String input = readLine();
        validateBridgeSize(input);
        System.out.println();
        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = readLine();
        validateMoving(input);
        return input;
    }

    public String readGameCommand() {
        String input = readLine();
        validateGameCommand(input);
        return input;
    }
}
