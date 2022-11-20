package message;

public enum ErrorMessage {
    BRIDGE_LENGTH_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVE_COMMAND_ERROR("[ERROR] 이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_COMMAND_ERROR("[ERROR] 게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return errorMessage;
    }
}
