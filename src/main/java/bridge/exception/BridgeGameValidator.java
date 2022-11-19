package bridge.exception;

import static bridge.common.BridgeGameConstants.MAX_SIZE;
import static bridge.common.BridgeGameConstants.MIN_SIZE;
import static bridge.common.BridgeGameConstants.UP;
import static bridge.common.BridgeGameConstants.DOWN;
import static bridge.common.BridgeGameConstants.RETRY;
import static bridge.common.BridgeGameConstants.QUIT;

public class BridgeGameValidator {

    private static final String ERROR_MESSAGE_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_UP_AND_DOWN = "[ERROR] '위: U 아래: D'로 입력하셔야 합니다.";
    private static final String ERROR_MESSAGE_RESTART_AND_QUIT = "[ERROR] '재시도: R 종료: Q'로 입력하셔야 합니다.";


    public static void isValidGameNumber(int number) {
        if (!(number >= MIN_SIZE && number <= MAX_SIZE)) {
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
        if(!(str.equals(UP) || str.equals(DOWN))){
            throw new IllegalArgumentException(ERROR_MESSAGE_UP_AND_DOWN);
        }
        return str;
    }

    public static String validateRestartAndQuit(String str){
        if(!(str.equals(RETRY) || str.equals(QUIT))){
            throw new IllegalArgumentException(ERROR_MESSAGE_RESTART_AND_QUIT);
        }
        return str;
    }
}
