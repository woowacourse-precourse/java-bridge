package bridge.utils;

import java.util.List;

public class Constants {
    public final static String UP = "U";
    public final static String DOWN = "D";
    public static final String UP_AND_FAIL = "UF";
    public static final String DOWN_AND_FAIL = "DF";
    public static final String COLLECT_MESSAGE = "O";
    public static final String FAIL_MESSAGE = "X";
    public static final String BLANK = " ";


    public final static List<String> SPACE_NAME = List.of(DOWN, UP);

    public static final int MINIMUM_BRIDGE_LENGTH = 3;
    public static final int MAXIMUM_BRIDGE_LENGTH = 20;
    public static final int SIZE_OF_SPACE_TO_MOVE = 1;
    public static final String ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_LENGTH = "[ERROR] 다리 길이는 3이상 20이하여야 합니다.";
    public static final String ERROR_MESSAGE_NOT_DIGIT = "[ERROR] 다리 길이는 숫자만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_SPACE_NAME = "[ERROR] 이동할 칸은 'U' 혹은 'D'만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_SPACE_INPUT_SIZE = "[ERROR] 이동할 칸은 하나의 문자만 입력 가능합니다.";

    //입력 관련 상수
    public static final String INPUT_MESSAGE_ENTER_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MESSAGE_ENTER_SPACE_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    //출력 관련 상수
    public static final String OPEN_BRACKET = "[ ";
    public static final String CLOSE_BRACKET = " ]";
    public static final String SEPARATOR = " | ";

}
