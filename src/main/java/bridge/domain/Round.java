package bridge.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Round {

    public static final int ROUND_LOWER_BOUND = 1;
    public static final int ROUND_UPPER_BOUND = 20;
    private static final Map<Integer, Round> CACHE = new HashMap<>();
    private static final String INVALID_ROUND_RANGE_MESSAGE = "허용된 라운드 범위를 벗어났습니다.";

    static {
        for (int i = ROUND_LOWER_BOUND; i <= ROUND_UPPER_BOUND; i++) {
            CACHE.put(i, new Round(i));
        }
    }

    private final Integer number;

    private Round(Integer number) {
        validate(number);
        this.number = number;
    }

    public static Round valueOf(Integer number) {
        validate(number);
        return CACHE.get(number);
    }

    private static void validate(Integer number) {
        if (number < ROUND_LOWER_BOUND || ROUND_UPPER_BOUND < number) {
            throw new IllegalArgumentException(INVALID_ROUND_RANGE_MESSAGE);
        }
    }

    public static List<Round> naturalOrder() {
        return IntStream.rangeClosed(ROUND_LOWER_BOUND, ROUND_UPPER_BOUND)
                .mapToObj(CACHE::get)
                .collect(toList());
    }
}
