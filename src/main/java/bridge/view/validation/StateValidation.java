package bridge.view.validation;

import static bridge.view.Message.ERROR_STATE_MESSAGE;

public class StateValidation {

    public static boolean stateValidation(String input){
        try {
            inNotValidation(input);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void inNotValidation(String input){
        if(!(input.equals("D") || input.equals("U"))){
            System.out.println(ERROR_STATE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
