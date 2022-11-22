package bridge.exception;

public class SizeOverException {
    private static final String BASIC_ERROR_MESSAGE = "[ERROR]";

    public static void bridgeSizeCheck(int bridgeSize) {
        if (20 < bridgeSize || bridgeSize < 3) {
            System.out.println(BASIC_ERROR_MESSAGE + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException(BASIC_ERROR_MESSAGE + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }//if
    }// sizeCheck

    public static void oneWordCheck(String userInput) {
        if (1 != userInput.length()) {
            System.out.println(BASIC_ERROR_MESSAGE + " 지정된 글자 한 글자만 입력해 주세요.");
            throw new IllegalArgumentException(BASIC_ERROR_MESSAGE + " 지정된 글자 한 글자만 입력해 주세요.");
        }//if
    }// sizeCheck
}// end class
