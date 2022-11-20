package bridge.util;

public enum SystemMessage {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_MOVE_BRIDGE("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private String message;
    SystemMessage(String message){
        this.message=message;
    }
    public String print(){
        return message;
    }
}
