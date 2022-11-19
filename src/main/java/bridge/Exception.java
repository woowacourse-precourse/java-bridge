package bridge;

public class Exception {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CONTAIN_CHARACTER = "Characters exist in the input value.";
    private static final String OUT_RANGE_OF_BRIDGE_SIZE = "An out-of-range number exists in the input value.";
    private static final String INVALID_INPUT_VALUE_FOR_MOVE = "Invalid input value to move.";

    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MIN_BRIDGE_SIZE = 3;

    private static final String USER_MOVE_UP = "U";
    private static final String USER_MOVE_DOWN = "D";

    private static final String COMMAND_RESTART = "R";
    private static final String COMMAND_QUIT = "Q";

    // TODO: 입력 값에 문자가 포함되어 있을 시 예외를 발생시킨다.
    public static int convertStringToInteger(String inputValue) throws IllegalArgumentException{
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_PREFIX + CONTAIN_CHARACTER);
        }
    }

    // TODO: 입력 값이 3에서 20사이가 아닐 시 예외를 발생시킨다.
    public static int validateRangeThreeToTwenty(int bridgeSize) throws IllegalArgumentException{
        if ( MIN_BRIDGE_SIZE <= bridgeSize && bridgeSize <= MAX_BRIDGE_SIZE)
            return bridgeSize;
        throw new IllegalArgumentException(ERROR_PREFIX + OUT_RANGE_OF_BRIDGE_SIZE);
    }

    // TODO: 입력 값이 U 혹은 D가 아닐 시 예외를 발생 시킨다.
    public static String validateInputValueForMove(String moving){
        if (moving.equals(USER_MOVE_UP) || (moving.equals(USER_MOVE_DOWN)))
            return moving;
        throw new IllegalArgumentException(ERROR_PREFIX + INVALID_INPUT_VALUE_FOR_MOVE);
    }

    // TODO: 입력 받은 게임 재시작 문자열이 'R'혹은 'Q'가 아닐 시 예외 처리한다.
    public static String validateInputValueForReStart(String gameCommand){
        if (gameCommand.equals(COMMAND_RESTART) || (gameCommand.equals(COMMAND_QUIT)))
            return gameCommand;
        throw new IllegalArgumentException(ERROR_PREFIX + INVALID_INPUT_VALUE_FOR_MOVE);
    }


}
