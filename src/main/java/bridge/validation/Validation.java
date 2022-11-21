package bridge.validation;

import static bridge.utils.constant.Constant.*;
import static bridge.utils.constant.Constant.RESTART;
import static bridge.utils.constant.ExceptionPhrase.*;

public class Validation {



    public void bridgeSizeIsInRange(int bridge) {
        if(bridge < 3 || bridge > 20) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_RANGE_IN_THREE_TO_TWENTY.getPhrase());
        }
    }

    public void moveIsUOrD(String move) {
        if(!(move.equals(UP.getValue()) || move.equals(DOWN.getValue()))) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_U_OR_D.getPhrase());
        }
    }

    public void quitOrRestart(String quit) {
        if(!(quit.equals(QUIT.getValue()) || quit.equals(RESTART.getValue()))) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_Q_OR_R.getPhrase());
        }
    }
}
