package bridge.util;

public class Constant {

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다";
    public static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVING_SELECT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String GAME_RESULT_MESSAGE = "최종 게임 결과";

    public static final int BRIDGE_SIZE_INPUT_RETRY_POINT = -1;
    public static final String BRIDGE_MOVE_INPUT_RETRY_POINT = "";
    public static final String BRIDGE_RETRY_COMMAND_INPUT_POINT = "";
    public static final int BRIDGE_FIRST_TRY_INDEX = 0;
    public static final int BRIDGE_ONE_TRY_SPACE_SIZE = 4;
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final int ADDITIONAL_NUMBER_FOR_EXCLUDE_BRACKET = 1;
    public static final String BRIDGE_FAIL_SPACE_BLANK = "   ";
    public static final String CLOSING_BRACKET = "]";
    public static final StringBuilder SUCCESSFUL_MARK = new StringBuilder(" O ");
    public static final StringBuilder FAILURE_MARK = new StringBuilder(" X ");
    public static final StringBuilder upsideBridge = new StringBuilder("[]");
    public static final StringBuilder downsideBridge = new StringBuilder("[]");

    public static final String SIZE_INPUT_TYPE_CHECK = "[0-9]+";
    public static final String SIZE_INPUT_TYPE_ERROR = "[ERROR] 다리 길이는 숫자만 입력할 수 있습니다.";
    public static final String SIZE_RANGE_ERROR = "[ERROR] 다리의 길이는 3 ~ 20 사이의 숫자만 입력할 수 있습니다.";
    public static final String MOVING_WORD_INPUT_ERROR = "[ERROR] 이동할 칸은 'U' 혹은 'D'만 입력할 수 있습니다.";
    public static final String RETRY_COMMAND_INPUT = "[ERROR] 'R' 혹은 'Q'만 입력할 수 있습니다.";

}
