package bridge.domain;

import bridge.common.ErrorMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Round {
    public static final int ROUND_LOWER_BOUND = 1;
    public static final int ROUND_UPPER_BOUND = 20;
    private static final Map<Integer, Round> CACHE = new HashMap<>();

    static {
        for (int i = ROUND_LOWER_BOUND; i <= ROUND_UPPER_BOUND; i++) {
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
        if (number < ROUND_LOWER_BOUND || number > ROUND_UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidRoundRange());
        }
    }

    public static List<Round> getRoundsOrderByOrderAsc() {
        return IntStream.rangeClosed(ROUND_LOWER_BOUND, ROUND_UPPER_BOUND)
                .mapToObj(CACHE::get)
                .collect(Collectors.toList());
    }
}
