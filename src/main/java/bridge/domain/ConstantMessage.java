package bridge;

public class ConstantMessage {
    static final String BRIDGE_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    static final String REQUEST_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    static final String REQUEST_MOVE_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String REQUEST_GAME_RETRY_ANSWER_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    static final String GAME_RESULT_MAP_MESSAGE = "최종 게임 결과";
    static final String GAME_RESULT_SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부 : ";
    static final String GAME_RETRY_COUNT_MESSAGE = "총 시도한 횟수 : ";

    static final String INVALID_RANGE_BRIDGE_LENGTH_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    static final String NOT_NUMBER_BRIDGE_LENGTH_MESSAGE = "[ERROR] 다리 길이는 숫자여야 합니다.";
    static final String INVALID_DIRECTION_MESSAGE = "[ERROR] 사용자가 움직일 수 있는 방향은 U 또는 D 입니다.";
    static final String INVALID_RETRY_COMMAND_MESSAGE = "[ERROR] 사용자가 입력할 수 있는 명령은 R 또는 Q 입니다.";
}
