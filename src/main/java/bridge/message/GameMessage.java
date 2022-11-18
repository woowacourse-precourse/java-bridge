package bridge.message;

public final class GameMessage {
    public static final String START_MSG = "다리 건너기 게임을 시작합니다.";
    public static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String REQUEST_MOVE_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String REQUEST_RETRY_SELECT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String GAME_FINISH_MSG = "최종 게임 결과";
    public static final String GAME_CLEAR_WHETHER = "게임 성공 여부: %s\n";
    public static final String TOTAL_TRY_COUNT = "총 시도한 횟수: %d\n";
}
