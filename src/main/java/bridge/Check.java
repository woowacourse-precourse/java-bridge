package bridge;

import bridge.exception.NotNumeric;

import static bridge.Utility.ERROR_MESSAGE;

public class Check {
    public static boolean checkNumeric(String input){
        try{
            Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            IllegalArgumentException exception = new NotNumeric(ERROR_MESSAGE);
            System.out.println(exception);
            return false;
        }
        return true;
    }

}
