package bridge.utils;

import bridge.domain.SizeOfBridge;

public class Constants {

    // SizeOfBridge Exception Message
    public static final String EXCEPTION_PREFIX = "[ERROR] : ";
    public static final String EMPTY_INPUT_MESSAGE = EXCEPTION_PREFIX + "입력이 정상적으로 진행되지 않았습니다.";
    public static final String WRONG_INPUT_SIZE_MESSAGE = EXCEPTION_PREFIX + "숫자를 올바르지 않게 입력했습니다.";
    public static final String WRONG_RANGE_MESSAGE =
        EXCEPTION_PREFIX + String.format("다리 길이의 범위는 최소 %d ~ %d 사이 입니다.",
            SizeOfBridge.START_INCLUSIVE, SizeOfBridge.END_INCLUSIVE);
    // Bridge Exception Message
    public static final String WRONG_BRIDGE_VALUE_MESSAGE = EXCEPTION_PREFIX + "다리의 구성요소가 잘못 생성되었습니다.";
    // Moving Command Message
    public static final String WRONG_MOVING_COMMAND_MESSAGE =  EXCEPTION_PREFIX + "이동 커멘드를 잘못 입력하였습니다.";
    public static final String NOT_EXIST_COMMAND_MESSAGE =  EXCEPTION_PREFIX + "존재하지 않는 커멘드 입니다.";
    // Regex
    public static final String NUMBER_PATTERN = "[1-9]+[0-9]*$";
    public static final String UPPER_PATTERN = "[A-Z]";
    // Bridge Situation
    public static final int UP_VALUE = 1;
    public static final int DOWN_VALUE = 0;
    public static final String UP_SITUATION = "U";
    public static final String DOWN_SITUATION = "D";

}
