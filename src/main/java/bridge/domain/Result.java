package bridge.domain;

public enum Result {
    SUCCESS(true, "성공"), FAIL(false, "실패");

    private final boolean isSuccess;
    private final String signal;

    Result(boolean isSuccess, String signal) {
        this.isSuccess = isSuccess;
        this.signal = signal;
    }

    /**
     * 성공 여부를 받아 Enum class 로 반환하는 메서드
     * @param isSuccess 성공 여부
     * @return Enum class
     */
    public static Result of(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    /**
     * 성공 여부를 받아 문자열의 단어로 반환하는 메서드
     * @param isSuccess 성공 여부
     * @return 성공 또는 실패
     */
    public static String getSignal(boolean isSuccess) {
        return Result.of(isSuccess).signal;
    }
}
