package bridge.constants;

public enum ErrorMessage {
    ERROR_NOT_INT("[ERROR] 다리 길이는 숫자여야 합니다."),
    ERROR_NOT_VALID_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_NOT_VALID_MOVE("[ERROR] 이동할 칸은 U 또는 D여야 합니다."),
    ERROR_NOT_VALID_COMMAND("[ERROR] 게임 재시도 여부는 R 또는 Q여야 합니다.");

    private final String description;
    ErrorMessage(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
}
