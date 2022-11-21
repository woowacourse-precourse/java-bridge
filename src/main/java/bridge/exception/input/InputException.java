package bridge.exception.input;

public class InputException {
    private static final String NUMERIC_PATTERN="\\d+";
    private static final int UNDER_RANGE=3;
    private static final int OVER_RANGE=20;
    private static final String MOVING_INPUT_PATTERN="^[UD]$";
    private static final String GAME_COMMAND_INPUT_PATTERN="^[RQ]$";

    private static final String BLANK="";

    public static boolean isNotProperInput(String userInput, String pattern){
        return !userInput.replaceAll(pattern, BLANK).equals(BLANK);
    }
    
}
