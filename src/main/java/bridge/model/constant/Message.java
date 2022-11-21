package bridge.model.constant;

public class Message {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_BRIDGE_SIZE = "잘못 입력했습니다. 3 이상 20 이하의 숫자를 입력해주세요.";
    public static final String ERROR_MOVING = "잘못 입력했습니다. U 또는 D를 입력해주세요.";
    public static final String ERROR_RETRY = "잘못 입력했습니다. R 또는 Q를 입력해주세요.";
    public static final String GAME_RESULT_MESSAGE = "\n최종 게임 결과";

    public static final String CORRECT_LOG = " O |";
    public static final String FAIL_LOG = " X |";
    public static final String EMPTY_LOG = "   |";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String RE_START = "R";
    public static final String QUIT = "Q";
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String START_MAP = "[";
    public static final String END_MAP = "]";
    public static final String NEXT_LINE = "\n";
    public static final String SUCCESS_OR_FAIL = "\n게임 성공 여부: ";
    public static final String TOTAL_TRY_COUNT_IS = "총 시도한 횟수: ";
}
