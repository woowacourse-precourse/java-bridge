package bridge.util;

public class Constant {

    public static final String BRIDGE_LENGTH_REGEX = "^[0-9]*$";
    public static final int BRIDGE_LENGTH_MIN = 3;
    public static final int BRIDGE_LENGTH_MAX = 20;
    public static final int FIRST_ROUND = 0;
    public static final String BLANK = " ";
    public static final String FIRST_ROUND_CORRECT = " O ";
    public static final String FIRST_ROUND_WRONG = " X ";
    public static final String OTHER_ROUND_CORRECT = "| O ]";
    public static final String OTHER_ROUND_WRONG = "| X ]";
    public static final String MAP_END = "]";
    public static final String FIRST_ROUND_END = "  ]";
    public static final String OTHER_ROUND_END = "|   ]";
    public static final String BRIDGE_INPUT_MSG = "\n다리의 길이를 입력해주세요.";
    public static final String MOVE_INPUT_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_RESTART_MSG = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String GAME_START_MSG = "다리 건너기 게임을 시작합니다.";

    public static final String ERROR_MESSAGE_BRIDGE_LENGTH_CONSIST_OF_NUM = "[ERROR] 다리 길이 입력값은 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_BRIDGE_LENGTH_RANGE_3_TO_20 = "[ERROR] 다리의 길이는 3이상 20이하여야 합니다.";
    public static final String ERROR_MESSAGE_BRIDGE_MOVE_COMMAND_INPUT_ERROR = "[ERROR] 다리 이동 입력값은 U 혹은 D이어야 합니다.";
    public static final String ERROR_MESSAGE_BRIDGE_GAME_COMMAND_INPUT_ERROR = "[ERROR] 게임 종료 후 재시작은 R 종료는 Q 입니다.";
    public static final String ERROR_MESSAGE_BRIDGE_MAKE_INPUT_ERROR = "[ERROR] 다리 생성시 건널 수 있는 위치 입력값은 1 혹은 0이어야 합니다.";

}
