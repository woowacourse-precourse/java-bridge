package bridge;

public enum ErrorMessage {

    BRIDGE_LENGTH_IS_ONLY_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    INPUT_VALUE_IS_ONLY_ONE_LENGTH("[ERROR] 입력값의 길이가 1이어야 합니다."),

    BRIDGE_LENGTH_IS_THREE_TO_TWENTY("[ERROR] 다리의 길이는 3이상 20이하여야 합니다."),
    MOVE_BRIDGE_SPACE_IS_U_OR_D("[ERROR] 이동할 다리의 칸은 U 또는 D 중 하나만 입력해야 합니다."),
    RETRY_ANSWER_IS_R_OR_Q("[ERROR] 재시도 여부에 대한 입력은 R 또는 Q 중 하나만 입력해야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
