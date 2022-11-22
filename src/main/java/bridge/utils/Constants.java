package bridge.utils;

import java.util.List;

public class Constants {
    public final static String UP = "U";
    public final static String DOWN = "D";
    public static final String FAIL = "F";
    public static final String UP_AND_FAIL = "UF";
    public static final String DOWN_AND_FAIL = "DF";
    public static final String RETRY = "R";
    public static final String QUIT = "Q";
    public static final int UPPER_NUMBER = 1;

    public final static List<String> SPACE_NAME = List.of(DOWN, UP);

    //예외처리 관련 상수
    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;
    public static final String DIGIT_PATTERN = "^[0-9]*$";
    private static final String ERROR = "[ERROR]";
    public static final String ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_SIZE = ERROR + " 다리 길이는 3이상 20이하여야 합니다.";
    public static final String ERROR_MESSAGE_NOT_DIGIT = ERROR + " 다리 길이는 숫자만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_SPACE_NAME = ERROR + " 이동할 칸은 'U' 혹은 'D'만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_GAME_COMMAND_NAME = ERROR + " 재시작 코드는 'Q' 또는 'R'만 입력 가능합니다.";

    //입력 관련 상수
    public static final String MESSAGE_START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.\n";
    public static final String COLLECT_MESSAGE = "O";
    public static final String FAIL_MESSAGE = "X";
    public static final String BLANK = " ";
    public static final String INPUT_MESSAGE_ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MESSAGE_ENTER_SPACE_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_MESSAGE_RETRY_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    //출력 관련 상수
    public static final String LF = "\n";
    public static final String OPEN_BRACKET = "[ ";
    public static final String CLOSE_BRACKET = " ]";
    public static final String SEPARATOR = " | ";
    public static final String OUTPUT_MESSAGE_SUCCESS = "성공";
    public static final String OUTPUT_MESSAGE_FAIL = "실패";
    public static final String OUTPUT_MESSAGE_FINAL_GAME_RESULT = "최종 게임 결과";
    public static final String OUTPUT_MESSAGE_IS_SUCCESS_GAME = "게임 성공 여부: ";
    public static final String OUTPUT_MESSAGE_TOTAL_TRY_COUNT = "총 시도한 횟수: ";
}
