package bridge.util;

public class Message {

    public static final String ILLEGAL_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n";
    public static final String ILLEGAL_MOVE_REQUEST_ERROR_MESSAGE = "[ERROR] 이동할 칸 선택은 (위: U, 아래: D)만 입력할 수 있습니다.\n";
    public static final String ILLEGAL_GAME_COMMAND_ERROR_MESSAGE = "[ERROR] 게임 재시작 여부는 (재시도: R, 종료: Q)만 입력할 수 있습니다.\n";
    public static final String ILLEGAL_PLAYER_POSITION_ERROR_MESSAGE = "[ERROR] 플레이어의 위치는 0부터 시작합니다.\n";
    public static final String ALREADY_FINISH_PLAYER_ERROR_MESSAGE = "[ERROR] 이미 완주한 플레이어 입니다.\n";

    public static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.\n";
    public static final String MOVE_INPUT_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)\n";
    public static final String GAME_COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n";

    public static final String GAME_RESULT_MESSAGE = "\n최종 게임 결과\n";
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n\n";
}
