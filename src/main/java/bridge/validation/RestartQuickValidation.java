package bridge.validation;

import bridge.Message.ErrorMessage;

public class RestartQuickValidation implements Validation{
    private static final String restart = "R";
    private static final String quick = "Q";

    @Override
    public void validate(String value) {
        isUpOrDown(value);
    }

    private void isUpOrDown(String move){
        if(!(move.equals(restart) || move.equals(quick))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RESTART_QUICK_VALID_STRING.getMessage());
        }
    }
}
