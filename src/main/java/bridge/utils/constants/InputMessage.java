package bridge.utils.constants;

public enum InputMessage {
    READ_GAME_RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    READ_BRIDGE_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    READ_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요.");
    private final String message;

    InputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
