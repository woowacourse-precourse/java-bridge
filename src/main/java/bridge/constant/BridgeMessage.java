package bridge.constant;

public class BridgeMessage {

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n"
            + "\n"
            + "다리의 길이를 입력해주세요.";
    public static final String MOVE_BRIDGE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String RETRY_BRIDGE_GAME_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String BRIDGE_GAME_OVER_MESSAGE = "최종 게임 결과";
    public static final String BRIDGE_GAME_IS_COMPLETED_MESSAGE = "\n게임 성공 여부: ";
    public static final String BRIDGE_GAME_SUCCESS_MESSAGE = "성공";
    public static final String BRIDGE_GAME_FAIL_MESSAGE = "실패";
    public static final String BRIDGE_GAME_TOTAL_COUNT_MESSAGE = "총 시도한 횟수: ";

    private BridgeMessage() {
    }

}
