package bridge.rule;

import bridge.domain.Bridge;
import static bridge.util.Constant.*;
import static bridge.util.Validator.*;

import bridge.view.InputView;

public class EndRule {

    public static String isComplete(Bridge bridge) {
        if (bridge.isLastStep()) {
            return COMPLETE;
        }
        return FAIL;
    }

    public static boolean selectQuit() {
        String command = InputView.readGameCommand();
        validateGameCommandInput(command);
        if (EndRule.isQuit(command)) {
            return true;
        }
        return false;
    }

    public static boolean isQuit(String command) {
        return command.equals(QUIT);
    }

}
