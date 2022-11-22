package bridge.constants;

public final class Constants {
    public static final int BRIDGE_SETTING_MOVED_UP = 1;
    public static final int BRIDGE_SETTING_MOVED_DOWN = 0;
    public static final int GAME_SETTING_BRIDGE_RANGE_START = 3;
    public static final int GAME_SETTING_BRIDGE_RANGE_END = 20;

    public static final String GAME_COMMAND_UP = "U";
    public static final String GAME_COMMAND_DOWN = "D";
    public static final String GAME_COMMAND_RETRY = "R";
    public static final String GAME_COMMAND_QUIT = "Q";

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String ENTER_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String ENTER_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String ENTER_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    public static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    public static final String GAME_FAILED_MESSAGE = "게임 성공 여부: 실패";
    public static final String TOTAL_CHALLENGES_COUNT = "총 시도한 횟수: ";

    public static final String ERROR_BRIDGE_LENGTH_NOT_NUMBER = "[ERROR] 다리 길이는 숫자여야 합니다.";
    public static final String ERROR_BRIDGE_LENGTH_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String ERROR_MOVING_INPUT = "[ERROR] 이동할 칸은 U또는 D여야 합니다.";
    public static final String ERROR_RETRYING_INPUT = "[ERROR] 게임종료 여부의 입력값은 R또는 Q여야 합니다.";

}
