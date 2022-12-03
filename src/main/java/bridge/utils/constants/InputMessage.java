package bridge.utils.constants;

public enum InputMessage {
    READ_GAME_RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: "+GameCommand.RETRY.getCommand()+", 종료: "+GameCommand.QUIT.getCommand()+")"),
    READ_BRIDGE_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: "+GameCommand.GO_UP.getCommand()+", 아래: "+GameCommand.GO_DOWN.getCommand()+")"),
    READ_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요.");
    private final String message;

    InputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
