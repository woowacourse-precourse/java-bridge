package bridge.domain;

public enum Result {
    SUCCESS(true), FAIL(false);

    private final boolean isSuccess;

    Result(boolean isSuccess) {
        this.isSuccess = isSuccess;
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
}
