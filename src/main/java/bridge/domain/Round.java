package bridge.domain;

import bridge.common.ErrorMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 20;
    private static final Map<Integer, Round> CACHE = new HashMap<>();

    static {
        for (int i = LOWER_BOUND; i <= UPPER_BOUND; i++) {
            CACHE.put(i, new Round(i));
        }
    }

    private final int number;

    private Round(final int number) {
        validate(number);
        this.number = number;
    }

    public static Round valueOf(final int number) {
        validate(number);
        return CACHE.get(number);
    }

    private static void validate(final int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidRoundRange());
        }
    }
}
