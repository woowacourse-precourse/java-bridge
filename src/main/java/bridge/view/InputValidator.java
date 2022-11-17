package bridge.view;

import bridge.domain.ExceptionMessage;

public class InputValidator {
   static final int START_LENGTH_RANGE = 3;
   static final int END_LENGTH_RANGE = 20;

    public void validateInputLength(String inputLength) {
        if (!isNumber(inputLength)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER);
        }
        if(!isInRange(inputLength)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE);
        }
    }

    private boolean isNumber(String inputLength){
        return inputLength.matches("^[0-9]*$");
    }

    private boolean isInRange(String inputLength){
        int bridgeLength = Integer.parseInt(inputLength);
        return bridgeLength >= START_LENGTH_RANGE && bridgeLength <= END_LENGTH_RANGE;
    }
}
