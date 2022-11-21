package bridge.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Round {

    public static final int ROUND_LOWER_BOUND = 1;
    public static final int ROUND_UPPER_BOUND = 20;
    private static final int ROUND_DIFFERENCE = 1;
    private static final Map<Integer, Round> CACHE = new HashMap<>();
    private static final String INVALID_ROUND_RANGE_MESSAGE = "허용된 라운드 범위를 벗어났습니다.";

    static {
        for (int i = ROUND_LOWER_BOUND; i <= ROUND_UPPER_BOUND; i++) {
            CACHE.put(i, new Round(i));
        }
    }

    private Integer round;

    private Round(Integer round) {
        validate(round);
        this.round = round;
    }

    public static Round valueOf(Integer round) {
        validate(round);
        return CACHE.get(round);
    }

    public Round nextRound() {
        return CACHE.getOrDefault(this.round + ROUND_DIFFERENCE, this);
    }

    private static void validate(Integer round) {
        if (round < ROUND_LOWER_BOUND || ROUND_UPPER_BOUND < round) {
            throw new IllegalArgumentException(INVALID_ROUND_RANGE_MESSAGE);
        }
    }

    public static Round firstRound() {
        return CACHE.get(ROUND_LOWER_BOUND);
    }

    public static List<Round> naturalOrder() {
        return IntStream.rangeClosed(ROUND_LOWER_BOUND, ROUND_UPPER_BOUND)
                .mapToObj(Round::valueOf)
                .collect(toList());
    }

    public static List<Round> naturalOrderWithSize(int size) {
        validate(size);
        return IntStream.rangeClosed(ROUND_LOWER_BOUND, size)
                .mapToObj(Round::valueOf)
                .collect(toList());
    }
}
