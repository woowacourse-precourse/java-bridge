package bridge.domain.constants;

public enum DomainError {
    ERROR_HEAD("[ERROR]"),
    INVALID_MOVE_COMMAND("위칸을 선택하려면 '"+
            Command.MOVE_UP.getCommand() +
            "', 아래칸을 선택하려면 '"
            +Command.MOVE_DOWN.getCommand() +
            "'를 입력해주세요."),
    INVALID_RETRY_COMMAND("재시도 시 '" +
            Command.RETRY.getCommand() +
            "', 게임을 종료하려면 '" +
            Command.QUIT.getCommand() +
            "'를 입력해주세요."),
    BRIDGE_LENGTH_OUT_OF_RANGE("다리의 길이는" +
            Constant.MINIMUM_LENGTH_INCLUSIVE.getValue() +
            "이상" +
            Constant.MAXIMUM_LENGTH_INCLUSIVE.getValue() +
            "이하의 정수여야 합니다.");
    private String message;
    DomainError(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
