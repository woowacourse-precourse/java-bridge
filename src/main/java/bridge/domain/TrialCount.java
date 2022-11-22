package bridge.domain;

public class TrialCount {

    private static final int INITIAL_TRIAL_COUNT = 1;
    private static final int TRIAL_COUNT_INCREASE_AMOUNT = 1;

    private int count = INITIAL_TRIAL_COUNT;

    public void increase() {
        count += TRIAL_COUNT_INCREASE_AMOUNT;
    }

    public int getCount() {
        return count;
    }
}
