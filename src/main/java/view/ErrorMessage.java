package view;

public enum ErrorMessage {
    SIZE_ERROR("3 이상 20 이하의 숫자가 아닙니다"),
    MOVING_ERROR("U(위 칸)와 D(아래 칸) 중 하나의 문자가 아닙니다"),
    NUMBER_ERROR("입력값이 숫자가 아닙니다"),
    CHARACTER_ERROR("영어가 아닙니다."),
    RESTART_ERROR("R(재시작)과 Q(종료) 중 하나의 문자가 아닙니다");

    private final String ERROR_PREFIX = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = ERROR_PREFIX + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
