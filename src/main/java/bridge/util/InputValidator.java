package bridge.util;

import bridge.constant.ErrorOutput;

public class InputValidator {
    public static boolean isNumber(String input) {
        try {
            int num = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            System.out.println(ErrorOutput.WRONG_NUMBER_TYPE);
            throw new IllegalArgumentException(ErrorOutput.WRONG_NUMBER_TYPE);
        }

        return true;
    }

    public static boolean isInteger(String input) {
        if(input.contains(".")) {
            System.out.println(ErrorOutput.WRONG_INTEGER_TYPE);
            throw new IllegalArgumentException(ErrorOutput.WRONG_INTEGER_TYPE);
        }

        return true;
    }


}
