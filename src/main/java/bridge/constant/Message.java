package bridge.constant;

public class Message {
    public static final String GAME_START = "다리 건너기 게임을 시작합니다.";

    public static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";

    public static final String BRIDGE_SIZE_NOT_DIGIT_MESSAGE = "숫자만 입력 가능합니다.";
    public static final String BRIDGE_SIZE_RANGE_OUT_MESSAGE = "다리의 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static final String MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U,아래: D)";
    public static final String INVALID_MOVE_INPUT_MESSAGE = "U 또는 D 만 입력 가능합니다.";

    public static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String INVALID_RETRY_MESSAGE = "R 또는 Q 만 입력 가능합니다.";

    public static final String ERROR_MESSAGE = "[ERROR] ";

    public static final String RESULT_MESSAGE = "최종 게임 결과";
    public static final String IS_SUCCESS_OR_FAIL = "게임 성공 여부: ";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
}
