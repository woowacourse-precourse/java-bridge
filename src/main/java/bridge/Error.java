package bridge;

public enum Error {
    ERROR_BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_MOVING("[ERROR] 이도 가능한 방향은 위쪽('U'), 아래쪽('D') 입니다."),
    ERROR_RETRY("[ERROR] 게임 종료 여부를 위한 입력값이 잘못되었습니다.");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
