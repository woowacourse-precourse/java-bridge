package bridge.constants;

public enum ValidatorMessage {

    BRIDGE_LENGTH_MESSAGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    RETRY_INPUT_IS_R_OR_Q("[ERROR] 재시도 여부는 재시도 : R, 종료 : Q로 입력해주세요."),
    NEXT_SPACE_IS_U_OR_D("[ERROR] 이동할 칸은 위 : U, 아래 : D로 입력해주세요.");

    private final String message;

    ValidatorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}