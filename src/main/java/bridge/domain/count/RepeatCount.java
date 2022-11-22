package bridge.domain.count;

public class RepeatCount {
    public static final String ERROR_COUNT_OVER_MAX_SIZE = "[ERROR] 더이상 시도할 수 없습니다.";

    private static final String RESULT_REPEAT_COUNT_MESSAGE = "총 시도한 횟수: %d";
    private final Integer count;

    public RepeatCount(final Integer count) {
        this.count = count;
    }

    public static RepeatCount initializeRepeatCount() {
        return new RepeatCount(1);
    }

    public RepeatCount increment(final Integer plusCount) {
        validateRepeatCountOverFlow(count, plusCount);

        return new RepeatCount(count + plusCount);
    }

    private void validateRepeatCountOverFlow(Integer count, Integer plusCount) {
        try {
            Math.addExact(count, plusCount);
        } catch (Exception exception) {
            throw new IllegalStateException(ERROR_COUNT_OVER_MAX_SIZE);
        }
    }

    public String result() {
        return String.format(RESULT_REPEAT_COUNT_MESSAGE, count);
    }
}
