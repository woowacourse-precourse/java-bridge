package bridge.util;

public enum SystemMessage {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_MOVE_BRIDGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    OUTPUT_BRIDGE_MAP_START("["),
    OUTPUT_BRIDGE_MAP_MIDDLE("|"),
    OUTPUT_BRIDGE_MAP_END("]"),
    OUTPUT_GAME_SUCCESS_OR_NOT("게임 성공 여부: %s\n"),
    OUTPUT_TOTAL_ATTEMPT_COUNT("총 시도한 횟수: %d\n"),
    FINAL_RESULT("최종 게임 결과");

    private String message;
    SystemMessage(String message){
        this.message=message;
    }
    public String print(){
        return message;
    }
}
