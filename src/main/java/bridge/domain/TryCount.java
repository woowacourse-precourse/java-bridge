package bridge.domain;

import static bridge.util.Constant.*;
import static bridge.util.Validator.*;

public class TryCount {

    private final int count;

    public TryCount(int count) {
        validateTryCount(count);
        this.count = count;
    }

    public TryCount addCount() {
        int newCount = count + ONECOUNT;
        return new TryCount(newCount);
    }

    public static TryCount initCount() {
        return new TryCount(ONECOUNT);
    }

    public int getCount() {
        return count;
    }
}
