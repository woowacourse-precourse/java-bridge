package bridge.domain;

import bridge.util.Constant;
import bridge.util.Validator;

public class TryCount {

    private final int count;

    public TryCount(int count) {
        Validator.validateTryCount(count);
        this.count = count;
    }

    public TryCount addCount() {
        int newCount = count + Constant.ONECOUNT;
        return new TryCount(newCount);
    }

    public static TryCount initCount() {
        return new TryCount(Constant.ONECOUNT);
    }

    public int getCount() {
        return count;
    }
}
