package bridge.model.value;

public enum OutMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다.%n"),
    INPUT_BRIDGE_MESSAGE("다리의 길이를 입력해주세요.%n"),
    INPUT_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)%n"),
    INPUT_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)%n"),
    PRINT_RESULT_MESSAGE("최종 게임 결과%n"),
    SUCCES_OR_NOT_MESSAGE("게임 성공 여부: %s%n"),
    TRY_COUNT_MESSAGE("총 시도한 횟수: %d"),
    PRINT_ENTER("%n");
    private final String message;
    OutMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
