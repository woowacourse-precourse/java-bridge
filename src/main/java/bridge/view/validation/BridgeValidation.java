package bridge.view.validation;

import static bridge.view.Message.ERROR_NOT_DIGIT_MESSAGE;
import static bridge.view.Message.ERROR_NOT_INRAGNE_MESSAGE;

public class BridgeValidation {

    public static boolean bridgeValidation(String size){
        try {
            isNumber(size);
            isInRange(Integer.parseInt(size));
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void isInRange(int size){
        if(size<3 || size>20){
            System.out.println(ERROR_NOT_INRAGNE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void isNumber(String size){
        if(!(size.chars().allMatch(Character::isDigit))){
            System.out.println(ERROR_NOT_DIGIT_MESSAGE);
            throw new NumberFormatException();
        }
    }

}
