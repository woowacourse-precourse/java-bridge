package bridge.message;

public class ProgressMessage {
    private ProgressMessage() {}

    public static String INIT_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static String BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    public static String BRIDGE_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static String RETRY_GAME_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static String GAME_RESULT_MESSAGE = "최종 게임 결과";
    public static String SUCCESS_GAME_MESSAGE = "게임 성공 여부: 성공";
    public static String FAIL_GAME_MESSAGE = "게임 성공 여부: 실패";
    public static String TOTAL_GAME_COUNT_MESSAGE = "총 시도한 횟수: ";

}
