package bridge;

public enum ViewMessage {
    START_GAME_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_DIRECTION_MOVE_BRIDGE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART_OR_QUIT_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT_GAME_MESSAGE("최종 게임 결과"),
    RESULT_GAME_SUCCESS_STATUS_MESSAGE("게임 성공 여부: "),
    RESULT_GAME_TRY_NUMBER_MESSAGE("총 시도한 횟수: ");

    private final String ViewMessage;
    ViewMessage(String message){
        this.ViewMessage = message;
    }

    public String getMessage() {
        return ViewMessage;
    }
}
