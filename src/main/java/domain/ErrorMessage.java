package domain;

public enum ErrorMessage {
    NOT_MATCHING_MOVING_COMMAND("[ERROR] 커맨드에 맞는 값(U, D)을 입력하여 주십시오."),
    NOT_MATCHING_GAME_COMMAND("[ERROR] 커맨드에 맞는 값(Q, R)을 입력하여 주십시오."),
    NOT_NUMBER("[ERROR] 숫자를 입력하여 주십시오."),
    NOT_BRIDGE_SIZE("[ERROR] 다리 길이는 3 이상 20 이하만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
