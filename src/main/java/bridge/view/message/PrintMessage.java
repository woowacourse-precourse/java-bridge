package bridge.view.message;

public abstract class PrintMessage {

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_BRIDGE_LINE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_BRIDGE_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_GAME_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    public static final String GAME_RESULT_SUCCESS_MESSAGE = "게임 성공 여부: %s";
    public static final String GAME_RESULT_TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";
    public static final String PRINT_BRIDGE_START = "[ ";
    public static final String PRINT_BRIDGE_END = " ]";
    public static final String PRINT_BRIDGE_SEPARATOR = " | ";
    public static final String BRIDGE_SPACE = " ";
    public static final String BRIDGE_SUCCESS = "O";
    public static final String BRIDGE_FAIL = "X";
    public static final String EMPTY = "";
}
