package utils;

public enum ErrorMessage {
    ERROR_BRIDGE_SIZE_RANGE(": 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_INT_INPUT_TYPE(": 정수만 입력 가능합니다."),
    ERROR_ANSWER_INPUT(": 'U': 윗층 다리, 'D': 아랫층 다리 | 두 가지의 입력만 가능합니다."),
    ERROR_GAME_RESTART_INPUT (": 'R': 재시작, 'Q': 종료 | 두 가지의 입력만 가능합니다.");

    private static final String ERROR = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = ERROR + errorMessage;
    }
    public String getErrorMessage(){
        return this.errorMessage;
    }
}
