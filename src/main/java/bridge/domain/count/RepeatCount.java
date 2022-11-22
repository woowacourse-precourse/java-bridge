package bridge.domain.count;

public class RepeatCount {
    public static final String ERROR_COUNT_OVER_MAX_SIZE = "[ERROR] 더이상 시도할 수 없습니다.";

    private static final String RESULT_REPEAT_COUNT_MESSAGE = "총 시도한 횟수: %d";
    private final Integer count;

    public RepeatCount(final Integer count) {
        validateRepeatCountLessThanMaxValue(count);
        this.count = count;
    }

    public static RepeatCount initializeRepeatCount() {
        return new RepeatCount(1);
    }

    private void validateRepeatCountLessThanMaxValue(Integer count) {
        System.out.println(count);
        if (count < 0) {
            throw new IllegalStateException(ERROR_COUNT_OVER_MAX_SIZE);
        }
    }

    public RepeatCount increment(final Integer plusCount) {
        return new RepeatCount(count + plusCount);
    }

    public String result() {
        return String.format(RESULT_REPEAT_COUNT_MESSAGE, count);
    }
}
