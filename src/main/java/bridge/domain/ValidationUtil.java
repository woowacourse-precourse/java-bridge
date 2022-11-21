package bridge.domain;

public class ValidationUtil {
    private static final String INVAILED_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static void bridgeSizeValidation(int bridgeSize){
        if(bridgeSize > 20 || bridgeSize < 3){
            throw new IllegalArgumentException(INVAILED_SIZE);
        }
    }
}
