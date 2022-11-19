package bridge;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public static void validatorOnlyNumber(String input){
        if(!NUMBER_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException(Error.NOT_NUMBER.getMessage());
        }
    }

    public static void validatorRangeNumber(String input){
        int InputToInt = Integer.parseInt(input);

        if(InputToInt > 20 || InputToInt < 3){
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.getMessage());
        }
    }

    public static void validatorMoving(String input){
        if(!(input.equals("U") || input.equals("D"))){
            throw new IllegalArgumentException(Error.NOT_U_OR_D.getMessage());
        }
    }

    public static void validatorRestartOREnd(String input){
        if(!(input.equals("R") || input.equals("Q"))){
            throw new IllegalArgumentException(Error.NOT_R_OR_Q.getMessage());
        }
    }
}
