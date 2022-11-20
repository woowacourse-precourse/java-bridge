package bridge.validator;

public class RetryInputValidator {

    public static final String RETRY_INPUT_IS_R_OR_Q = "[ERROR] 재시도 여부는 재시도 : R, 종료 : Q로 입력해주세요.";

    public static void validateRetryInput(String nextSpace) {
        if (!nextSpace.equals("R") && !nextSpace.equals("Q")) {
            throw new IllegalArgumentException(RETRY_INPUT_IS_R_OR_Q);
        }
    }
}
