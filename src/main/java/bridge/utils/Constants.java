package bridge.utils;

import bridge.domain.SizeOfBridge;

public class Constants {

    // Exception Message
    public static final String EXCEPTION_PREFIX = "[ERROR] : ";
    public static final String EMPTY_INPUT_MESSAGE = EXCEPTION_PREFIX + "입력이 정상적으로 진행되지 않았습니다.";
    public static final String WRONG_INPUT_SIZE_MESSAGE = EXCEPTION_PREFIX + "숫자를 올바르지 않게 입력했습니다.";
    public static final String WRONG_RANGE_MESSAGE =
        EXCEPTION_PREFIX + String.format("다리 길이의 범위는 최소 %d ~ %d 사이 입니다.",
            SizeOfBridge.START_INCLUSIVE, SizeOfBridge.END_INCLUSIVE);
    // Regex
    public static final String NUMBER_PATTERN = "[0-9]";


}
