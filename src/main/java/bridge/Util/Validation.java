package bridge.Util;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String CHAR_ERROR_SENTENCE = " 숫자만 입력 해야합니다.";
    private static final String RANGE_ERROR_SENTENCE = " 3과 20 사이의 숫자를 입력 해야합니다.";
    private static final String NUMERIC_ERROR_SENTENCE = " 문자를 입력 해야합니다.";
    private static final String OTHER_CHAR_ERROR_SENTENCE = " U나 D를 입력 해야합니다.";
    private static final String LENGTH_ERROR_SENTENCE = " 유효한 길이가 아닙니다.";

    public void isValidateSize(String inputLength){
        checkChar(inputLength);
        checkRange(Integer.parseInt(inputLength));
    }

    public void checkChar(String inputLength) {
        if(!inputLength.matches("^-?[0-9]+$")){
            throw new IllegalArgumentException(ERROR_MESSAGE + CHAR_ERROR_SENTENCE);
        }
    }

    public void checkRange(int bridgeLength) {
        if(bridgeLength < 3 || bridgeLength >20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + RANGE_ERROR_SENTENCE);
        }
    }

    public void isValidateMove(String inputMove) {
        isNumeric(inputMove);
        isValidateLength(inputMove);
        isValidateChar(inputMove);
    }

    private void isNumeric(String inputMove) {
        if(inputMove.matches("^-?[0-9]+$")){
            throw new IllegalArgumentException(ERROR_MESSAGE + NUMERIC_ERROR_SENTENCE);
        }
    }

    private void isValidateLength(String inputMove) {
        if(inputMove.length() != 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LENGTH_ERROR_SENTENCE);
        }
    }

    private void isValidateChar(String inputMove) {
        if("U".matches(inputMove) || "D".matches(inputMove)){
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + OTHER_CHAR_ERROR_SENTENCE);
    }
}
