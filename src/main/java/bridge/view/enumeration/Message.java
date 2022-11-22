package bridge.view.enumeration;

public enum Message {
    BRIDGE_SIZE_REQUEST_MESSAGE("다리의 길이를 입력해주세요."),
    MOVING_REQUEST_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_COMMAND_REQUEST_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    WHETHER_SUCCESS("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    TOTAL_RETRY_COUNT_IS("총 시도한 횟수: "),
    LAST_GAME_RESULT_MESSAGE("최종 게임 결과");

    private final String message;

    Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
