package bridge.domain.constants;

public enum ErrorMessage {
    ERROR_HEAD("[ERROR]"),
    INVALID_MOVE_COMMAND("위칸을 선택하려면 'U', 아래칸을 선태갛려면 'D'를 입력해주세요."),
    INVALID_RETRY_COMMAND("재시도 시 'R', 게임을 종료하려면 'Q'를 입력해주세요."),
    BRIDGE_LENGTH_OUT_OF_RANGE("다리의 길이는 3 이상 20 이하의 정수여야 합니다."),
    IS_NOT_INTEGER("다리의 길이는 3 이상 20 이하의 정수여야 합니다."),
    COMMAND_LENGTH_OUT_OF_RANGE("커맨드는 하나의 대문자 알파벳으로 주어져야 합니다.");




    private String message;
    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
