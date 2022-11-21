package bridge.system;

public class Validation {

    private static final String CHAR_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String ERROR_BRIDGE_SIZE_RANGE = "[ERROR] 3~20 사이의 자연수만 입력해주세요";
    private static final String NUMERIC_ERROR_MESSAGE = "[ERROR] 문자를 입력 해야합니다.";
    private static final String OTHER_MOVE_ERROR_MESSAGE = "[ERROR] U나 D를 입력 해야합니다.";
    private static final String OTHER_COMMAND_ERROR_MESSAGE = "[ERROR] R이나 Q를 입력 해야합니다.";
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 유효한 길이가 아닙니다.";

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public void validateBridgeSize(String size){
        checkChar(size);
        checkRange(Integer.parseInt(size));
    }

    public void checkChar(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(CHAR_ERROR_MESSAGE);
        }
    }

    public void checkRange(int bridgeSize) {
        if(bridgeSize < MIN_SIZE || MAX_SIZE < bridgeSize) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_RANGE);
        }
    }

    public void isValidateMove(String inputMove) {
        isValidateLength(inputMove);
    }

    public void isValidateCommand(String inputCommand) {
        isValidateLength(inputCommand);
    }

    private void isValidateLength(String input){
        if(input.length() != 1) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }
}
