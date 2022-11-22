package bridge.utils.constants;

public enum ErrorMessage {
    ERROR_GAME_COMMAND("[ERROR] 다시 입력하세요. (재시도: "+GameCommand.RETRY.getCommand()+", 종료: "+GameCommand.QUIT.getCommand()+")"),
    ERROR_BRIDGE_MOVE_MESSAGE("[ERROR] 이동할 수 있는 칸은 "+GameCommand.GO_UP.getCommand()+" 또는 "+GameCommand.GO_DOWN.getCommand()+"의 문자입니다."),
    ERROR_BRIDGE_SIZE_MESSAGE("[ERROR] 옳바른 다리의 길이를 입력해주세요.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
