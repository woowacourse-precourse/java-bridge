package bridge.global;

public enum ErrorMessage {

    INPUT_NUMBER_ERROR("[ERROR] 숫자를 입력해야 합니다."),
    INPUT_BRIDGE_LENGTH_ERROR("[ERROR] 다리의 길이는 3이상 20 이하 이어야 합니다."),
    INPUT_GUESS_BLOCK_ERROR("[ERROR] 다리의 칸은 U 또는 D로만 이루어져 있습니다."),
    INPUT_RETRY_ERROR("[ERROR] 게임 재시도 여부 명령어는 R 또는 Q로만 이루어져 있습니다."),
    GAME_INTERNAL_ERROR("[ERROR] 게임 실행 오류 입니다.");
    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
