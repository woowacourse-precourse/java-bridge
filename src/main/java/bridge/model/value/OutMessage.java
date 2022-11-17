package bridge.model.value;

public enum OutMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    PRINT_BRIDGE_STATE(""), //TODO: 나중에 Service로직이 구현되고 작성
    RESULT_MESSAGE("게임 성공 여부: %s"),
    TRY_COUNT_MESSAGE("총 시도한 횟수: %d");
    private final String message;
    OutMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
