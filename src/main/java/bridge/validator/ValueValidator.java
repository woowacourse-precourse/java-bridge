package bridge.validator;

import bridge.constant.ErrorMessage;

public class ValueValidator {
    private static final int MINIMUM_NUMBER = 3;
    private static final int MAXIMUM_NUMBER = 20;

    public void validateNumberRange(int number){
        if(number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
        }
    }

    public void validateRetryOrQuit(String option){
        if(!option.equals("R") && !option.equals("Q")){
            throw new IllegalArgumentException(ErrorMessage.INVALID_OPTION);
        }
    }

    public void validateUpOrDown(String option){
        if(!option.equals("U") && !option.equals("D")){
            throw new IllegalArgumentException(ErrorMessage.INVALID_OPTION);
        }
    }
}
