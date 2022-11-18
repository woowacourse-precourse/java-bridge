package bridge;

import java.util.regex.Pattern;

public class BridgeInputErrorCheck {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NOT_NUMBER_ERROR = ERROR_MESSAGE+" 숫자를 입력해야 합니다.";
    private static final String NUMBER_SIZE_ERROR = ERROR_MESSAGE+" 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String NUMBER_PATTERN = "^[0-9]{1,}$";
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;


    public void readBridgeSizeErrorCheck(String bridgeSize){

        if(!Pattern.matches(NUMBER_PATTERN, bridgeSize))
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);

        int size = Integer.parseInt(bridgeSize);
        if( size < BRIDGE_SIZE_MIN || size > BRIDGE_SIZE_MAX)
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR);
    }
}