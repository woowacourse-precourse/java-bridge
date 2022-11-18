package bridge.exception;

public class BridgeGameValidator {

    private static final String ERROR_MESSAGE_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_UP_AND_DOWN = "[ERROR] '위: U 아래: D'로 입력하셔야 합니다.";


    public static void isValidGameNumber(int number) {
        if (!(number >= 3 && number <= 20)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_SIZE);
        }
    }

    public static int validateInt(String str){
        try {
            int stringToInt = Integer.parseInt(str);
            return stringToInt;
        }catch (Exception e){
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_SIZE);
        }
    }

    public static void validateUpAndDown(String str){
        if(!(str=="U" || str=="D")){
            throw new IllegalArgumentException(ERROR_MESSAGE_UP_AND_DOWN);
        }
    }
}
