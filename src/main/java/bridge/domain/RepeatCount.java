package bridge.domain;

public class RepeatCount {
    private static final String RESULT_MSG = "총 시도한 횟수: %d";

    private int count;

    private RepeatCount(int count) {
        this.count = count;
    }

    public static RepeatCount initRepeatCount() {
        return new RepeatCount(1);
    }

    public void increment() {
        this.count += 1;
    }

    public int getCount() {
        return count;
    }

    public String getResult() {
        return String.format(RESULT_MSG, count);
    }
}
