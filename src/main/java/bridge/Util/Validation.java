package bridge.Util;

public class Validation {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String CHAR_ERROR_SENTENCE = " 숫자만 입력 해야합니다.";
    private static final String RANGE_ERROR_SENTENCE = " 3과 20 사이의 숫자를 입력 해야합니다.";
    private static final String NUMERIC_ERROR_SENTENCE = " 문자를 입력 해야합니다.";
    private static final String OTHER_CHAR_ERROR_SENTENCE = " U나 D를 입력 해야합니다.";
    private static final String OTHER_COMMAND_ERROR_SENTENCE = " R이나 Q를 입력 해야합니다.";
    private static final String LENGTH_ERROR_SENTENCE = " 유효한 길이가 아닙니다.";
    private static final String CHECK_NUMBER_REGEX = "^-?[0-9]+$";

    private static final String RESET_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";
    private static final String UPPER_CASE = "U";
    private static final String LOWER_CASE = "D";
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    public void isValidateSize(String inputLength){
        checkChar(inputLength);
        checkRange(Integer.parseInt(inputLength));
    }

    public void checkChar(String inputLength) {
        if(!inputLength.matches(CHECK_NUMBER_REGEX)){
            throw new IllegalArgumentException(ERROR_MESSAGE + CHAR_ERROR_SENTENCE);
        }
    }

    public void checkRange(int bridgeLength) {
        if(bridgeLength < MIN_LENGTH || bridgeLength > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + RANGE_ERROR_SENTENCE);
        }
    }

    public void isValidateMove(String inputMove) {
        isNumeric(inputMove);
        isValidateLength(inputMove);
        isValidateMoveChar(inputMove);
    }

    public void isValidateCommand(String inputCommand) {
        isNumeric(inputCommand);
        isValidateLength(inputCommand);
        isValidateCommandChar(inputCommand);
    }

    private void isNumeric(String input) {
        if(input.matches(CHECK_NUMBER_REGEX)){
            throw new IllegalArgumentException(ERROR_MESSAGE + NUMERIC_ERROR_SENTENCE);
        }
    }

    private void isValidateLength(String input){
        if(input.length() != 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LENGTH_ERROR_SENTENCE);
        }
    }

    private void isValidateMoveChar(String inputMove) {
        if(inputMove.matches(UPPER_CASE) || inputMove.matches(LOWER_CASE)){
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + OTHER_CHAR_ERROR_SENTENCE);
    }

    private void isValidateCommandChar(String inputCommand) {
        if(inputCommand.matches(RESET_COMMAND) || inputCommand.matches(QUIT_COMMAND)){
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + OTHER_COMMAND_ERROR_SENTENCE);
    }
}
