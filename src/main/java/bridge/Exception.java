package bridge;

public class Exception {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CONTAIN_CHARACTER = "Characters exist in the input value.";
    private static final String OUT_RANGE_OF_BRIDGE_SIZE = "An out-of-range number exists in the input value.";
    private static final String INVALID_INPUT_VALUE_FOR_MOVE = "Invalid input value to move.";

    // TODO: 입력 값에 문자가 포함되어 있을 시 예외를 발생시킨다.
    public static int convertStringToInteger(String inputValue) throws IllegalArgumentException{
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_PREFIX + CONTAIN_CHARACTER);
        }
    }
}
