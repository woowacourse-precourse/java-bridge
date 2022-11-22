package bridge.domain;

import java.util.regex.Pattern;

public class InputErrorCheck {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NOT_NUMBER_ERROR = ERROR_MESSAGE+" 숫자를 입력해야 합니다.";
    private static final String NUMBER_SIZE_ERROR = ERROR_MESSAGE+" 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String MOVING_SPACE_ERROR = ERROR_MESSAGE+" 이동할 칸은 U 혹은 D 중에서 선택해야 합니다.";
    private static final String COMMAND_ERROR = ERROR_MESSAGE+" 재시도 : R, 종료 : Q 중에서 선택해야 합니다.";
    private static final String NUMBER_PATTERN = "^[0-9]{1,}$";
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;
    private static final String MOVE_UP = "U";
    private static final String MOVE_DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";


    public static void readBridgeSizeErrorCheck(String bridgeSize){

        if(!Pattern.matches(NUMBER_PATTERN, bridgeSize))
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);

        int size = Integer.parseInt(bridgeSize);
        if( size < BRIDGE_SIZE_MIN || size > BRIDGE_SIZE_MAX)
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR);
    }
    public static void readMovingErrorCheck(String movingSpace){
        if ( !movingSpace.equals(MOVE_UP) && !movingSpace.equals(MOVE_DOWN))
            throw new IllegalArgumentException(MOVING_SPACE_ERROR);
    }

    public static void readGameCommandErrorCheck(String command){
        if ( !command.equals(RETRY) && !command.equals(QUIT))
            throw new IllegalArgumentException(COMMAND_ERROR);
    }
}