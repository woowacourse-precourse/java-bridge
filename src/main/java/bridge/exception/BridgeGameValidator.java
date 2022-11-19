package bridge.exception;

public class BridgeGameValidator {

    private static final String ERROR_MESSAGE_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_UP_AND_DOWN = "[ERROR] '위: U 아래: D'로 입력하셔야 합니다.";
    private static final String ERROR_MESSAGE_RESTART_AND_QUIT = "[ERROR] '재시도: R 종료: Q'로 입력하셔야 합니다.";


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

    public static String validateUpAndDown(String str){
        if(!(str.equals("U") || str.equals("D"))){
            throw new IllegalArgumentException(ERROR_MESSAGE_UP_AND_DOWN);
        }
        return str;
    }

    public static void validateRestartAndQuit(String str){
        if(!(str.equals("R") || str.equals("Q"))){
            throw new IllegalArgumentException(ERROR_MESSAGE_RESTART_AND_QUIT);
        }
    }
}
