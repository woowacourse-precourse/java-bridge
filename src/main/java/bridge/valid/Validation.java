package bridge.valid;

import bridge.type.ErrorType;

public class Validation {

    public static void inputNumberValid(String number) {
        int convertNumber = 0;
        try {
            convertNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INPUT_ERROR_TYPE.getText());
        }

        if (convertNumber < 1 || convertNumber > 20){
            throw new IllegalArgumentException(ErrorType.INPUT_ERROR_TYPE.getText());
        }
    }
}
