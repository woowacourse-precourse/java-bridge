package bridge.Util;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String CHAR_ERROR_SENTENCE = " 숫자만 입력 해야합니다.";
    private static final String RANGE_ERROR_SENTENCE = " 3과 20 사이의 숫자를 입력 해야합니다.";

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
}
