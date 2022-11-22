package bridge.constants;

public abstract class Message {

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String BRIDGE_MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String ASK_TO_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String FINAL_GAME_RESULT_GUIDE_MESSAGE = "최종 게임 결과";
    public static final String FINAL_GAME_SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부: ";
    public static final String FINAL_GAME_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String EMPTY = "";

    public static final String INPUT_PATTERN_ERROR_MESSAGE = "[ERROR] 입력값이 정수가 아닙니다.";
    public static final String BRIDGE_INPUT_ERROR_MESSAGE = "[ERROR] 다리 길이의 입력 범위가 잘못되었습니다.";
    public static final String MOVING_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U 혹은 D 중 하나의 문자를 입력해야 합니다.";
    public static final String COMMAND_ERROR_MESSAGE = "[ERROR] 재시작/종료 여부는 R 혹은 Q 중 하나의 문자를 입력해야 합니다.";

    private Message() {}
}
