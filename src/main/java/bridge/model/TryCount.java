package bridge.model;

import bridge.error.Error;
import java.util.concurrent.atomic.AtomicInteger;

public class TryCount {

    private static final int START_TRY_COUNT = 1;
    private static final int MAX_TRY = Integer.MAX_VALUE;

    private final AtomicInteger value;

    public TryCount() {
        value = new AtomicInteger(START_TRY_COUNT);
    }

    public void increase() {
        if (value.get() == MAX_TRY) {
            throw new IllegalArgumentException(Error.MAX_TRY_ERROR.getMessage());
        }

        value.getAndIncrement();
    }

    public int getValue() {
        return value.get();
    }
}
