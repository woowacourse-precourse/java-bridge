package bridge.global;

public enum BridgeMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LEN("다리의 길이를 입력해주세요."),
    INPUT_MOVE_BLOCK("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_END("최종 게임 결과"),
    UP("U"),
    DOWN("D"),
    QUIT("Q"),
    RUN("R");
    
    private String message;

    BridgeMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
