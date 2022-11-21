package bridge.rule;

import bridge.domain.Bridge;
import bridge.util.Constant;
import bridge.util.Validator;
import bridge.view.InputView;

public class EndRule {

    public static String isComplete(Bridge bridge) {
        if (bridge.isLastStep()) {
            return Constant.COMPLETE;
        }
        return Constant.FAIL;
    }

    public static boolean selectQuit() {
        String command = InputView.readGameCommand();
        Validator.validateGameCommandInput(command);
        if (EndRule.isQuit(command)) {
            return true;
        }
        return false;
    }

    public static boolean isQuit(String command) {
        return command.equals(Constant.QUIT);
    }

}
