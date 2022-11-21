package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {

    static final int BRIDGE_MIN_LENGTH = 3;
    static final int BRIDGE_MAX_LENGTH = 20;

    public static String getValidateInput(InputType inputType) {
        if (inputType == InputType.BRIDGE) return checkValidateBridge(getLine());
        if (inputType == InputType.MOVE) return "";
        if (inputType == InputType.REPLAY) return "";
        return null;
    }
    public static String getLine(){
        try{
            return Console.readLine();
        }catch (Exception e){
            throw new IllegalArgumentException(Message.NONE_INPUT_ERROR);
        }
    }
    public static String checkValidateBridge(String input){
        int num = checkIsDigit(input);
        checkIsValidBridgeRange(num);
        return input;
    }

    public static void checkIsValidBridgeRange(int num) {
        if(num < BRIDGE_MIN_LENGTH || num > BRIDGE_MAX_LENGTH){
            throw new IllegalArgumentException(Message.BRIDGE_LENGTH_RANGE_ERROR);
        }
    }

    public static int checkIsDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.BRIDGE_LENTH_NUM_ERROR);
        }
    }


}
