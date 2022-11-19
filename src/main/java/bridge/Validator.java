package bridge;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public static void validatorOnlyNumber(String input){
        if(!NUMBER_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException();
        }
    }

    public static void validatorRangeNumber(String input){
        int InputToInt = Integer.parseInt(input);

        if(InputToInt > 20 || InputToInt < 3){
            throw new IllegalArgumentException();
        }
    }

    public static void validatorMoving(String input){
        if(!(input.equals("U") || input.equals("D"))){
            throw new IllegalArgumentException();
        }
    }

    public static void validatorRestartOREnd(String input){
        if(!(input.equals("R") || input.equals("Q"))){
            throw new IllegalArgumentException();
        }
    }
}
