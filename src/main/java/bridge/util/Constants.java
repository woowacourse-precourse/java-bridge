package bridge.util;

import bridge.domain.game.MovingType;

public class Constants {

    // 검증 로직
    public static final int MIN_LENGTH_OF_BRIDGE = 3;
    public static final int MAX_LENGTH_OF_BRIDGE = 20;
    public static final String REGULAR_EXPRESSION_FOR_NUM = "[+-]?\\d+(\\.\\d+)?";
    public static final String REGULAR_EXPRESSION_FOR_ENG = "^[a-zA-Z]*$";


    // 에러 처리 관련
    public static final String NO_MATCHING_MOVING_TYPE_FOUND = "[ERROR] 해당 값에 해당하는 이동 유형을 찾을 수 없음";
    public static final String OUT_OF_RANGE_OF_BRIDGE =
            String.format("[ERROR] 다리 길이는 %d 이상 %d 이하여야 합니다.",
                                                    MAX_LENGTH_OF_BRIDGE,
                                                    MIN_LENGTH_OF_BRIDGE);
    public static final String IS_NOT_NUMERIC_VALUE = "[ERROR] 입력 값이 숫자가 아닙니다.";
    public static final String INVALID_MOVING_TYPE = "[ERROR] 입력된 이동 옵션 값이 유효한 옵션이 아닙니다.";
    public static final String IS_NOT_ENGLISH = "[ERROR] 입력 값이 영어가 아닙니다.";
    public static final String INVALID_RESTART_OPTION = "[ERROR] 입력된 재시작 옵션 값이 유효한 옵션이 아닙니다.";

    // 게임 로직
    public static final String RESTART_OPTION = "R";
    public static final String QUIT_OPTION = "Q";
    public static final int ROUND_COUNT_INIT_VALUE = 1;
    public static final int USER_LOCATION_INIT_VALUE = -1;
    public static final String NO_INPUT = " ";
    public static final String IS_CORRECT = "O";
    public static final String IS_WRONG = "X";

    // 가이드 문장
    public static final String START_GUIDE = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_BRIDGE_LENGTH_GUIDE = "\n다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING_GUIDE =
            String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
                    MovingType.MOVING_UP.getEngNotation(),
                    MovingType.MOVING_DOWN.getEngNotation());
    public static final String INPUT_RESTART_OPTION_GUIDE =
            String.format("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s",
                    RESTART_OPTION,
                    QUIT_OPTION);
    public static final String RETRY_GUIDE = "[ERROR] 다시 입력해주십시오. (현재 %d번 시도)\n";

    // 아웃풋
    public static final String RESULT_GUIDE = "최종 게임 결과";
    public static final String RESULT_MAP_PREFIX = "[ ";
    public static final String RESULT_MAP_SUFFIX = " ]";
    public static final String RESULT_MAP_DELIMITER = " | ";
    public static final String SEPARATOR = "\n";
    public static final String COUNT_STRING_GUIDE = "총 시도한 횟수: %d";
    public static final String IS_CORRECT_STRING_GUIDE = "게임 성공 여부: %s";
    public static final String CORRECT_STRING = "성공";
    public static final String WRONG_STRING = "실패";

}
